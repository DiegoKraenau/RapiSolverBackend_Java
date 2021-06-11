package com.rapisolver.service.services.impl;

import com.rapisolver.service.dtos.CreateUserRapiServiceDTO;
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

    @Override
    public UserRapiServiceDTO create(CreateUserRapiServiceDTO c) throws RuntimeException {
        // Category Validation
        Category category = categoryRepository.findByName(c.getCategoryName()).orElseThrow(()-> new NotFoundException("CATEGORY_NOT_FOUND"));

        try {

            // Supplier validation
            // TODO: Implement communication with supplier service

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
                    .build();
            userRapiService = repository.save(userRapiService);
            return mapper.map(userRapiService, UserRapiServiceDTO.class);
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
