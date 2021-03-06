package com.rapisolver.service.services.impl;

import com.rapisolver.service.client.UserClient;
import com.rapisolver.service.dtos.CreateUserRapiServiceDTO;
import com.rapisolver.service.dtos.ListUserRapiServiceDTO;
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

import java.util.ArrayList;
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
            SupplierDTO supplier = userClient.findSupplier(c.getSupplierId()).orElseThrow(()->new NotFoundException("SUPPLIER_NOT_FOUND"));
            //Example
            // SupplierDTO supplier = SupplierDTO.builder().id(2L).firstName("Diego").lastName("Kraenau").email("diegokraenau@gmail.com").role("CUSTOMER").build();

            if(supplier.getRole().equals("SUPPLIER")){
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
                        .supplierId(supplier.getId())
                        .build();

                // Mapping response
                userRapiService = repository.save(userRapiService);
                UserRapiServiceDTO response = UserRapiServiceDTO.builder().id(userRapiService.getId()).price(userRapiService.getPrice()).detail(userRapiService.getDetail()).build();
                response.setSupplier(supplier);
                return response;
            }else{
                throw new NotFoundException("CANT_PUBLIC");
            }


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


    @Override
    public ListUserRapiServiceDTO getServicesBySupplierId(Long id) throws RuntimeException {
        SupplierDTO supplier = userClient.findSupplier(id).orElseThrow(()->new NotFoundException("SUPPLIER_NOT_FOUND"));
        List<UserRapiService> userRapiServices = repository.findBySupplierId(id).orElseThrow(()->new ServiceNotFoundException("SERVICES_NOT_FOUND"));
        List<UserRapiServiceDTO> listServices = new ArrayList<>();
        for (UserRapiService urs:userRapiServices){
            UserRapiServiceDTO ursdto = mapper.map(urs,UserRapiServiceDTO.class);
            ursdto.setSupplier(supplier);
            listServices.add(ursdto);
        }
        return ListUserRapiServiceDTO.builder().userRapiServiceDTOList(listServices).build();
    }
}
