package com.play.controller;

import com.play.dao.PdTransactionIdMapping;
import com.play.repository.PdTransactionIdMappingRepository;
import com.play.service.UserService;
import io.micronaut.context.annotation.Value;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.net.http.HttpClient;

@Controller("/v1")
@Slf4j
public class UserController {

    @Value("${micronaut.environment}")
    private String environment;
    @Inject
    private UserService userService;
    @Inject
    private HttpClient httpClient;
    @Inject
    private PdTransactionIdMappingRepository pdTransactionIdMappingRepository;

    @Get(value = "/user", produces = MediaType.APPLICATION_JSON)
    public Page<PdTransactionIdMapping> testJoin() {
        Sort.Order order = new Sort.Order("u.firstName", Sort.Order.Direction.DESC, false);
        Pageable pageable = Pageable.from(0, 25, Sort.of(order));

        Page<PdTransactionIdMapping> pdTransactionIdMappings = pdTransactionIdMappingRepository
                .findByAgentIdAndAgentFirstNameContainsAndEnterpriseIdAndIsScheduled
                        (25399, "vishnu", 2, PdTransactionIdMapping.IsScheduled.FALSE, pageable);

        return pdTransactionIdMappings;
    }
}
