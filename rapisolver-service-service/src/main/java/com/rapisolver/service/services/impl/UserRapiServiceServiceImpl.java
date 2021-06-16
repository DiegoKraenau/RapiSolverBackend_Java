package com.rapisolver.service.services.impl;

import com.rapisolver.service.client.UserClient;
import com.rapisolver.service.dtos.CreateUserRapiServiceDTO;
import com.rapisolver.service.dtos.SupplierDTO;
import com.rapisolver.service.dtos.UserRapiServiceDTO;
import com.rapisolver.service.entities.Category;
import com.rapisolver.service.entities.RapiService;
import com.rapisolver.service.entities.UserRapiService;
import com.rapisolver.service.exceptions.InternalServerException;
import com.rapisolver.service.exceptions.NotFoundException;
import com.rapisolver.service.exceptions.ServiceInternalErrorException;
import com.rapisolver.service.exceptions.ServiceNotFoundException;
import com.rapisolver.service.repositories.CategoryRepository;
import com.rapisolver.service.repositories.RapiServiceRepository;
import com.rapisolver.service.repositories.UserRapiServiceRepository;
import com.rapisolver.service.services.UserRapiServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRapiServiceServiceImpl implements UserRapiServiceService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRapiServiceRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RapiServiceRepository rapiServiceRepository;

    @Autowired
    private UserClient userClient;

    @Override
    public UserRapiServiceDTO create(CreateUserRapiServiceDTO c) throws RuntimeException {
        // Category Validation
        Category category = categoryRepository.findByName(c.getCategoryName()).orElseThrow(()-> new NotFoundException("CATEGORY_NOT_FOUND"));

        try {

            // Supplier validation
            // SupplierDTO supplier = userClient.findSupplier(c.getSupplierId()).orElseThrow(()->new NotFoundException("SUPPLIER_NOT_FOUND"));
            //Example
            SupplierDTO supplierExample = SupplierDTO.builder().id(2L).name("Diego").lastName("Kraenau").email("diegokraenau@gmail.com").build();


            //Create Service
            RapiService service = RapiService.builder()
                            .name(c.getServiceName())
                            .category(category)
                            .build();
            rapiServiceRepository.save(service);

            //Create UserService

            UserRapiService userRapiService = UserRapiService.builder()
                    .detail(c.getDetail())
                    .price(c.getPrice())
                    .service(service)
                    .supplierId(supplierExample.getId())
                    .build();

            // Mapping response
            userRapiService = repository.save(userRapiService);
            UserRapiServiceDTO response = mapper.map(userRapiService, UserRapiServiceDTO.class);
            response.setSupplier(supplierExample);
            return response;
        } catch (Exception e) {
            throw new InternalServerException("CREATE_USER_SERVICE_ERROR");
        }
    }

    @Override
    public List<UserRapiServiceDTO> getAll() throws RuntimeException {
        List<UserRapiService> userRapiServices = repository.findAll();
        return userRapiServices.stream().map(us -> mapper.map(us, UserRapiServiceDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserRapiServiceDTO getById(Long id) throws RuntimeException {
        UserRapiService userRapiServiceDB = repository.findById(id).orElseThrow(() -> new ServiceNotFoundException("USER_SERVICE_NOT_FOUND"));
        return mapper.map(userRapiServiceDB, UserRapiServiceDTO.class);
    }
}
