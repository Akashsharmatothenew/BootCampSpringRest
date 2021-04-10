package com.project.ecommerce.projectEcommerce.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ecommerce.projectEcommerce.Repository.*;
import com.project.ecommerce.projectEcommerce.dto.*;
import com.project.ecommerce.projectEcommerce.entities.*;
import com.project.ecommerce.projectEcommerce.exception.*;
import org.json.simple.JSONArray;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryMetadataFieldValueRepository categoryMetadataFieldValueRepository;
    @Autowired
    ProductVariationRepository productVariationRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ImageService imageService;


    public boolean addProduct(Principal principal, ProductRequestDTO productRequestDTO) {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        if (seller == null) {
            throw new UserNotFoundException("There is no seller found. ");
        } else {
            Category category = categoryRepository.findById(productRequestDTO.getCategoryId()).orElse(null);
            Product productByName = productRepository.findByNameAndSellerAndBrandAndCategory(productRequestDTO.getName(), seller, productRequestDTO.getBrand(), category);
            if (productByName == null) {
                List<Long> categories = categoryRepository.fetchLeafCategoryId();
                if (categories.contains(productRequestDTO.getCategoryId())) {
                    ModelMapper modelMapper = new ModelMapper();
                    Product product = modelMapper.map(productRequestDTO, Product.class);
                    product.setSeller(seller);
                    productRepository.save(product);
                    User user = userRepository.findByEmail("Akashsharma1@gmail.com");
                    emailService.sendEmail(user.getEmail(), "Activation of Product",
                            "This is my new Product :" + productRequestDTO.getName() + "\n" +
                                    "Brand :" + productRequestDTO.getBrand() + "\nDescription: " + productRequestDTO.getDescription() + "\nCategory: " + productRequestDTO.getCategoryId() + " \n Please activate this product.");
                    return true;
                } else
                    throw new ChildCategoryNotFoundException("This is not a Leaf category");
            } else
                throw new ProductAlreadyExistsException("the product already exists with seller");
        }
    }


    public ProductResponseDTO viewProduct(Principal principal, Long productId) {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("There is no product found in the database");
        } else if (product.getSeller().getId().equals(seller.getId())) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProductResponseDTO productResponseDTO = modelMapper.map(product, ProductResponseDTO.class);
            return productResponseDTO;
        } else
            throw new ProductNotFoundException("Seller is not associated with this product");
    }


    public PageImpl<ProductPagingResponseDTO> viewAllProduct(Principal principal, Pageable pageable) {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "productId");
        Page<Product> productPage = productRepository.findAllBySellerAndDeleted(seller, false ,pageable);
        List<ProductPagingResponseDTO> productPagingResponseDtos = productPage.stream().map(this::toSellerAllProductsDTO).collect(Collectors.toList());
        return new PageImpl<ProductPagingResponseDTO>(productPagingResponseDtos);

    }

    private ProductPagingResponseDTO toSellerAllProductsDTO(Product product) {
        return new ProductPagingResponseDTO(product.getName(), product.getProductId(), product.getCategory(), product.getDescription(), product.getBrand(), product.getSeller(), product.getCategory());
    }




    public boolean deleteProduct(Principal principal, Long productId) {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        Product product = productRepository.findByProductIdAndSeller(productId, seller);
        if (product == null) {
            throw new ProductNotFoundException("There is no product associated with this seller");
        } else {
            product.setIsDeleted(true);
            productRepository.save(product);
            return true;
        }
    }


    public boolean updateProduct(Principal principal, ProductUpdateRequestDTO productUpdateRequestDTO) {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        Product product = productRepository.findByProductIdAndSeller(productUpdateRequestDTO.getProductId(), seller);
        if (product == null) {
            throw new ProductNotFoundException("There is no product associated with this seller");
        } else {
            if (productUpdateRequestDTO.getName() != null) {
                Product productByName = productRepository.findByNameAndSellerAndBrandAndCategory(productUpdateRequestDTO.getName(), seller, product.getBrand(), product.getCategory());
                if (productByName == null) {
                    product.setName(productUpdateRequestDTO.getName());
                    product.setDescription(productUpdateRequestDTO.getDescription());
                    product.setIsCancellable(productUpdateRequestDTO.getIsCancellable());
                    product.setIsReturnable(productUpdateRequestDTO.getIsReturnable());
                    productRepository.save(product);
                    return true;
                } else
                    throw new ProductAlreadyExistsException("The product already exists with this name");
            }
        }
        return false;
    }


    public boolean activateProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("The Product is not Found");
        } else {
            product.setIsActive(true);
            productRepository.save(product);
            emailService.sendEmail(product.getSeller().getEmail(), "Product Activated", "Your product listed for activation is now activated");
            return true;
        }
    }


    public boolean deactivateProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("The Product is not Found");
        } else {
            product.setIsActive(false);
            productRepository.save(product);
            emailService.sendEmail(product.getSeller().getEmail(), "Product De-Activated", "Your product is now de-activated");
            return true;
        }
    }


    public boolean addProductVariation(MultipartFile image, Principal principal, ProductVariationRequestDTO productVariationRequestDTO) throws MetadataFieldValueNotFoundException, IOException {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        Product product = productRepository.findById(productVariationRequestDTO.getProductId()).orElse(null);
        Long categoryId = productVariationRequestDTO.getCategoryId();
        if (categoryId.equals(product.getCategory().getCategoryId())) {
            if (product.getSeller().equals(seller)) {
                JSONArray metadataValues = productVariationRequestDTO.getMetadataValues();
                for (Object object:metadataValues) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Map<String, Object> map = objectMapper.convertValue(object, Map.class);
                    map.put("category_id", categoryId);
                    Object fieldId = map.get("metadata_field_id");
                    List<String> metadata = (List<String>) map.get("metadata");
                    String values = categoryMetadataFieldValueRepository.fetchMetadataValues(categoryId, fieldId);
                    List<String> valuesList=Arrays.asList(values.split(","));
                    for (String str : metadata) {
                        if (valuesList.contains(str)) {
                            throw new MetadataFieldValueNotFoundException("There is no metadata for given category id and field id");

                        }
                    }
                }
                productVariationRequestDTO.setMetadata(metadataValues.toString());
                // productVariationRequestDTO.setPrimaryImageName(imageProduct);
                ModelMapper modelMapper=new ModelMapper();
                modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                ProductVariation productVariation = modelMapper.map(productVariationRequestDTO, ProductVariation.class);
                product.insertProductVariation(productVariation);
                productVariationRepository.save(productVariation);
                return true;
            }else
                throw new ProductNotFoundException("There is no product associated with this seller");
        }else
            throw new CategoryNotFoundException("There is no product associated with this category");
    }


    public ProductVariationResponseDTO viewProductVariation(Principal principal, Long productVariationId) throws ProductVariationNotFoundException {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        ProductVariation productVariation = productVariationRepository.findById(productVariationId).orElse(null);
        Long id = productVariation.getProduct().getSeller().getId();
        if (id.equals(seller.getId()) && !productVariation.getProduct().getIsDeleted()) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProductVariationResponseDTO productVariationResponseDTO = modelMapper.map(productVariation, ProductVariationResponseDTO.class);
            return productVariationResponseDTO;
        } else {
            throw new ProductVariationNotFoundException("There is no product variation ");
        }
    }


    public Page<AllProductVariationResponseDTO> viewAllProductVariations(Principal principal, Long productId, Pageable pageable) {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        Product product = productRepository.findById(productId).orElse(null);
        List<ProductVariation> productVariation = productVariationRepository.findByProduct(product, pageable);
        if (product.getSeller().getId().equals(seller.getId())) {
            List<AllProductVariationResponseDTO> allProductVariationResponseDTOS=productVariation.stream().map(this::toSellerAllProductsResponseDTO).collect(Collectors.toList());
            return new PageImpl<AllProductVariationResponseDTO>(allProductVariationResponseDTOS);
        }
        return null;
    }


    private AllProductVariationResponseDTO toSellerAllProductsResponseDTO(ProductVariation productVariation) {
        return new AllProductVariationResponseDTO(productVariation.getProductVariationId(),productVariation.getMetadata(),productVariation.getPrice(),productVariation.getQuantityAvailable(),productVariation.getProduct().getProductId(),productVariation.getPrimaryImageName());
    }


    public Boolean updateProductVariation(Principal principal, UpdateVariationDTO updateVariationDTO) throws IOException,
            MetadataFieldValueNotFoundException {
        String username = principal.getName();
        Seller seller = sellerRepository.findByEmail(username);
        ProductVariation productVariation =
                productVariationRepository.findById(updateVariationDTO.getProductVariationId()).orElse(null);
        if (productVariation.getProduct().getSeller().getId().equals(seller.getId())) {
            if (productVariation.getProduct().getIsActive() && !productVariation.getProduct().getIsDeleted()) {
                if (updateVariationDTO.getIsActive() != null) {
                    productVariation.setIsActive(updateVariationDTO.getIsActive());
                    productVariationRepository.save(productVariation);
                    return true;
                }
                if (updateVariationDTO.getQuantityAvailable() != null) {
                    productVariation.setQuantityAvailable(updateVariationDTO.getQuantityAvailable());
                    productVariationRepository.save(productVariation);
                    return true;
                }
                if (updateVariationDTO.getPrice() != null) {
                    productVariation.setPrice(updateVariationDTO.getPrice());
                    productVariationRepository.save(productVariation);
                    return true;
                }
                if (updateVariationDTO.getMetadataArray() != null) {

                    Long categoryId = productVariation.getProduct().getCategory().getCategoryId();
                    JSONArray array = updateVariationDTO.getMetadataArray();
                    for (Object object : array) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        Map<String, Object> map = objectMapper.convertValue(object, Map.class);
                        map.put("category_id", categoryId);
                        Object fieldId = map.get("metadata_field_id");
                        List<String> metadata = (List<String>) map.get("metadatavalues");
                        String values = categoryMetadataFieldValueRepository.fetchMetadataValues(categoryId,fieldId);
                        List<String> valuesList = Arrays.asList(values.split(","));
                        for (String str : metadata) {
                            if (valuesList.contains(str)) {
                                throw new MetadataFieldValueNotFoundException("There is no metadata for given category id and field id");
                            }
                        }
                    }
                    productVariation.setMetadata(array.toString());
                    productVariationRepository.save(productVariation);
                    return true;
                }
            }else
                throw new ProductNotFoundException("There is no product associated");
        }else
            throw new ProductNotFoundException("There is no product associated iwth this repository");
        return null;
    }


    public CustomerProductResponseDTO viewProductCustomer(Long productId) {
        Product product=productRepository.findById(productId).orElse(null);
        if(product==null)
            throw new ProductNotFoundException("There is no product with the given id ");
        else
        {
            if(!product.getIsDeleted()){
                if(product.getIsActive()) {
                    if (!product.getProductVariations().isEmpty()) {
                        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                        CustomerProductResponseDTO customerProductResponseDTOS = modelMapper.map(product, CustomerProductResponseDTO.class);
                        return customerProductResponseDTOS;
                    } else {
                        throw new ProductNotFoundException("Product Variation is empty");
                    }
                }
                else{
                    throw new ProductNotFoundException("Product is not active ");
                    }
            } else {
                throw new ProductNotFoundException("Product is deleted");
            }
        }
    }


    private CustomerProductResponseDTO toAdminAllProductsResponseDTO(Product product) {
        return new CustomerProductResponseDTO(product.getProductId(),product.getName(),product.getDescription(),product.getIsActive(),product.getIsCancellable(),product.getIsReturnable(),product.getBrand(),product.getCategory(),product.getProductVariations());
    }


    public Page<CustomerProductResponseDTO> viewAllProductCustomer(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElse(null);
        if(category==null)
            throw new CategoryNotFoundException("There is no category with the given id ");
        else
        {
            List<Long> longList=categoryRepository.fetchLeafCategoryId();
            if(longList.contains(categoryId)){
                List<Product> product=productRepository.findByCategoryAndDeleted(category,false);
                List<CustomerProductResponseDTO> adminProductResponseDTOS = product.stream().map(this::toAdminAllProductsResponseDTO).collect(Collectors.toList());
                return new PageImpl<CustomerProductResponseDTO>(adminProductResponseDTOS);
            }else
                throw new ChildCategoryNotFoundException("This is not a Leaf Category");
        }
    }

    public Page<CustomerProductResponseDTO> viewSimilarProductsCustomer(Long productId, Pageable pageable) {
        pageable=PageRequest.of(0,10, Sort.Direction.DESC,"productId");
        Product product=productRepository.findById(productId).orElse(null);
        if(product==null){
            throw new ProductNotFoundException("There is no product with this id");
        }
        else{

            List<Product> products=productRepository.fetchSimilarProductsAndDeleted(product.getCategory().getCategoryId(),pageable);
            List<CustomerProductResponseDTO> customerProductResponseDTOS=products.stream().map(this::toAdminAllProductsResponseDTO).collect(Collectors.toList());
            return new PageImpl<CustomerProductResponseDTO>(customerProductResponseDTOS);
        }

    }


    public Page<CustomerProductResponseDTO> viewAllProductAdmin(Pageable pageable) {
        pageable=PageRequest.of(0,10, Sort.Direction.DESC,"productId");
        Page<Product> products = productRepository.findAll(pageable);
        if (products == null)
            throw new ProductNotFoundException("There are no products ");
        else {
            List<CustomerProductResponseDTO> adminProductResponseDTOS = products.stream().map(this::toAdminAllProductsResponseDTO).collect(Collectors.toList());
            return new PageImpl<CustomerProductResponseDTO>(adminProductResponseDTOS);
        }
    }


    public CustomerProductResponseDTO viewProductAdmin(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null)
            throw new ProductNotFoundException("There is no product with the given id ");
        else {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            CustomerProductResponseDTO customerProductResponseDTOS = modelMapper.map(product, CustomerProductResponseDTO.class);
            return customerProductResponseDTOS;
        }
    }
}
