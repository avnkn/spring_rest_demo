package demo.spring.rest.controllers.api;

import demo.spring.rest.entity.Application;
import demo.spring.rest.entity.Contact;
import demo.spring.rest.exceptions.RequestNotFoundException;
import demo.spring.rest.repository.ApplicationRepository;
import demo.spring.rest.repository.ContactRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class ApplicationController {
    private final ApplicationRepository applicationRepository;
    private final ContactRepository contactRepository;

    ApplicationController(
        final ApplicationRepository applicationRepository,
        final ContactRepository contactRepository
    ) {
        this.applicationRepository = applicationRepository;
        this.contactRepository = contactRepository;
    }

    @Operation(summary = "Get the latest application for contact")
    @ResponseBody
    @GetMapping(path = "/last-application-contact/{contactId}", produces = {"application/json", "application/xml"})
    public Application getLastRequestContact(
        @Parameter(description = "Id of contact") @PathVariable Integer contactId,
        @RequestParam(name = "mediaType", required = false, defaultValue = "json") String mediaType
    ) {
        Application application = applicationRepository.getLastApplicationContact(contactId);
        if (application == null) {
            throw new RequestNotFoundException(contactId);
        }
        return application;
    }

    @Operation(summary = "Get all contacts")
    @GetMapping(path = "/contact/", produces = "application/json")
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Operation(summary = "Get all application")
    @GetMapping(path = "/application/", produces = "application/json")
    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }
}
