package com.project.ecommerce.projectEcommerce.Service;


import com.project.ecommerce.projectEcommerce.Repository.CategoryMetadataFieldRepository;
import com.project.ecommerce.projectEcommerce.Repository.CategoryMetadataFieldValueRepository;
import com.project.ecommerce.projectEcommerce.Repository.CategoryRepository;
import com.project.ecommerce.projectEcommerce.dto.CategoryMetadataFieldResponseDTO;
import com.project.ecommerce.projectEcommerce.dto.CategoryMetadataFieldValueRequestDTO;
import com.project.ecommerce.projectEcommerce.dto.CategoryResponseDTO;
import com.project.ecommerce.projectEcommerce.dto.CustomerCategoryResponseDTO;
import com.project.ecommerce.projectEcommerce.entities.Category;
import com.project.ecommerce.projectEcommerce.entities.CategoryMetadataField;
import com.project.ecommerce.projectEcommerce.entities.CategoryMetadataFieldValue;
import com.project.ecommerce.projectEcommerce.exception.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMetadataFieldRepository categoryMetadataFieldRepository;

    @Autowired
    CategoryMetadataFieldValueRepository categoryMetadataFieldValueRepository;

    @Autowired
    ModelMapper modelMapper;


    public boolean addCategory(String name, Long parentId) {
        if (name != null && parentId != null) {
            Category categoryByName = categoryRepository.findByName(name);
            if (categoryByName == null) {
                Category category = categoryRepository.findById(parentId).orElse(null);
                Category childCategory = new Category();
                childCategory.setName(name);
                childCategory.setParentCategory(category);
                Set<Category> parent = new HashSet<>();
                parent.add(childCategory);
                childCategory.setChildCategory(parent);
                categoryRepository.save(childCategory);
                return true;
            } else
                throw new CategoryAlreadyExistsException("Category is already present in database");
        } else if (name != null || parentId != null) {
            Category categoryByName = categoryRepository.findByName(name);
            if (categoryByName == null) {
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
                return true;
            } else
                throw new ParentCategoryAlreadyExistsException("Parent Category is already present in database");
        }
        return false;
    }


    public CategoryResponseDTO viewCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new CategoryNotFoundException("There is no record with this category");
        } else {
            ModelMapper modelMapper = new ModelMapper();
            CategoryResponseDTO categoryResponseDTO = modelMapper.map(category, CategoryResponseDTO.class);
            List<Category> nextChildCategoryList=categoryRepository.fetchNextChild(category.getCategoryId());
            categoryResponseDTO.setNextCategory(nextChildCategoryList);
            return categoryResponseDTO;
        }
    }



    public Page<CategoryResponseDTO> allCategories(Pageable pageable) {
        //    pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "categoryId");
        Page<Category> categories = categoryRepository.findAll(pageable);
        ModelMapper modelMapper = new ModelMapper();
        Type typeList = new TypeToken<Page<CategoryResponseDTO>>() {
        }.getType();
        Page<CategoryResponseDTO> categoryDTOList = modelMapper.map(categories, typeList);
        return categoryDTOList;
    }
    


    public boolean updateCategory(Long categoryId, String name) {
        Category categoryByName = categoryRepository.findByName(name);
        if (categoryByName != null) {
            throw new CategoryAlreadyExistsException("The category already exists in the database");
        } else {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            if (category != null) {
                category.setName(name);

                categoryRepository.save(category);
                return true;
            } else
                throw new CategoryNotFoundException("There is no category with the given id");
        }
    }


    public boolean addMetadata(String fieldName) {
        CategoryMetadataField categoryMetadataField = categoryMetadataFieldRepository.findByName(fieldName);
        if (categoryMetadataField == null) {
            CategoryMetadataField newCategoryMetadataField = new CategoryMetadataField();
            newCategoryMetadataField.setName(fieldName);
            categoryMetadataFieldRepository.save(newCategoryMetadataField);
            return true;
        }
        else
            return false;
    }


    public Page<CategoryMetadataFieldResponseDTO> viewMetadataField(Pageable pageable) {
        Page<CategoryMetadataField> categoryMetadataFields = categoryMetadataFieldRepository.findAll(pageable);
        List<CategoryMetadataFieldResponseDTO> categoryMetadataFieldResponseDTOList = categoryMetadataFields.getContent().stream().map(this::toCategoryMetadataFieldResponseDto).collect(Collectors.toList());
        return new PageImpl<CategoryMetadataFieldResponseDTO>(categoryMetadataFieldResponseDTOList);
    }


    private CategoryMetadataFieldResponseDTO toCategoryMetadataFieldResponseDto(CategoryMetadataField categoryMetadataField) {
        return new CategoryMetadataFieldResponseDTO(categoryMetadataField.getCategoryMetadataFieldId(), categoryMetadataField.getName());
    }


    public boolean addMetadataFieldValue(CategoryMetadataFieldValueRequestDTO categoryMetadataFieldValueRequestDTO) {
        Category category = categoryRepository.findById(categoryMetadataFieldValueRequestDTO.getCategoryId()).orElse(null);
        Integer length=categoryMetadataFieldValueRequestDTO.countArray();
        Integer loop=0;
        while(loop<length) {
            CategoryMetadataField categoryMetadataField = categoryMetadataFieldRepository.findById(categoryMetadataFieldValueRequestDTO.getMetadataFieldId(loop)).orElse(null);
            if (category == null) {
                throw new CategoryNotFoundException("There is no category present with this id");
            }
            if (categoryMetadataField == null) {
                throw new CategoryMetadataFieldNotFoundException("There is no metadata field with this id");
            } else {
                CategoryMetadataFieldValue categoryMetadataFieldValue = new CategoryMetadataFieldValue(category, categoryMetadataField);
                categoryMetadataFieldValue.setMetadataValues(categoryMetadataFieldValueRequestDTO.getMetadataValues(loop));
                categoryMetadataFieldValueRepository.save(categoryMetadataFieldValue);
                loop++;
            }
        }
        return true;
    }


    public boolean updateMetadataFieldValue(CategoryMetadataFieldValueRequestDTO categoryMetadataFieldValueRequestDTO) {
        Category category = categoryRepository.findById(categoryMetadataFieldValueRequestDTO.getCategoryId()).orElse(null);
        Integer length=categoryMetadataFieldValueRequestDTO.countArray();
        Integer loop=0;
        while(loop<length) {
            CategoryMetadataField categoryMetadataField = categoryMetadataFieldRepository.findById(categoryMetadataFieldValueRequestDTO.getMetadataFieldId(loop)).orElse(null);
            if (category == null) {
                throw new CategoryNotFoundException("There is no category present with this id");
            }
            if (categoryMetadataField == null) {
                throw new CategoryMetadataFieldNotFoundException("There is no metadata field with this id");
            } else {
                CategoryMetadataFieldValue valueById = categoryMetadataFieldValueRepository.findByFieldIdCategoryCategoryIdAndFieldIdCategoryMetadataFieldCategoryId(category.getCategoryId(), categoryMetadataField.getCategoryMetadataFieldId()).orElse(null);
                if (valueById == null) {
                    throw new CategoryMetadataFieldValueNotFoundException("There is no category metadata field value available in the database");
                }else{
                    List<String> values = new ArrayList<>();
                    for (String s : valueById.getMetadataValues()) {
                        values.add(s);
                    }
                    List<String> newValue = categoryMetadataFieldValueRequestDTO.getMetadataValues(loop);
                    String addedValues = categoryMetadataFieldValueRequestDTO.convertToString(newValue);
                    values.add(addedValues);
                    valueById.setMetadataValues(values);
                    categoryMetadataFieldValueRepository.save(valueById);
                    loop++;
                }
            }
        }
        return true;
    }


    public List<CategoryResponseDTO> sellerListCategories() {
        List<Long> longList=categoryRepository.fetchLeafCategoryId();
        Iterable<Category> category=categoryRepository.findAllById(longList);
        Type typeList = new TypeToken<List<CategoryResponseDTO>>() {
        }.getType();
        ModelMapper modelMapper = new ModelMapper();
        List<CategoryResponseDTO> categoryDTOList = modelMapper.map(category, typeList);
        return categoryDTOList;
    }


    public List<CustomerCategoryResponseDTO> customerAllCategories(Long categoryId, Pageable pageable) {

        if(categoryId!=null) {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            if (category == null) {
                throw new CategoryNotFoundException("There is no category found with this id");
            } else {
                modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
                CustomerCategoryResponseDTO customerCategoryDTO = modelMapper.map(category, CustomerCategoryResponseDTO.class);
                return Arrays.asList(customerCategoryDTO);
            }
        }else{
            List<Long> longList=categoryRepository.fetchParentId();
            Iterable<Category> categories=categoryRepository.findAllById(longList);
            Type typeList=new TypeToken<List<CustomerCategoryResponseDTO>>(){}.getType();
            List<CustomerCategoryResponseDTO> customerCategoryDTOS=modelMapper.map(categories,typeList);
            return customerCategoryDTOS;
        }
    }


}
