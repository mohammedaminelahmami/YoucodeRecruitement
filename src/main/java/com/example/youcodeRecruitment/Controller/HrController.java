package com.example.youcodeRecruitment.Controller;


import com.example.youcodeRecruitment.Entity.Candidate;
import com.example.youcodeRecruitment.Entity.Skills;
import com.example.youcodeRecruitment.Repository.CandidateRepository;
import com.example.youcodeRecruitment.Request.CandidatRequest;
import com.example.youcodeRecruitment.Request.HrRequest;
import com.example.youcodeRecruitment.Service.CandidatService;
import com.example.youcodeRecruitment.Service.HrService;
import com.example.youcodeRecruitment.dto.CandidateDTO;
import com.example.youcodeRecruitment.dto.HRDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class HrController {
    private final HrService hrService;
    private final CandidatService candidatService;

    //   function update HR
    @PutMapping("/Hr/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable String id ,@RequestBody @Valid HrRequest hrRequest) {
        hrService.updateHr(hrRequest, Long.parseLong(id));
    }

    //    function delete Hr
    @DeleteMapping("/Hr/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        hrService.deleteHr(Long.parseLong(id));
    }

    //    function get one Hr
    @GetMapping("/Hr/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HRDTO getOne(@PathVariable String id) {
        return hrService.getOneHr(Long.parseLong(id));
    }

    //    Method get all HRS
    @GetMapping("/Hrs")
    @ResponseStatus(HttpStatus.OK)
    public List<HRDTO> getAllById(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit) {
        return hrService.getAllHrs(page, limit);
    }

//    Method get all by First name
//    @GetMapping("/Hrs/search")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CandidateDTO> search(@RequestParam(value = "firstname", required = false) String firstName,
//                                  @RequestParam(value = "lastname", required = false) String lastName,
//                                  @RequestParam(value = "frontend_skills", required = false) String frontend_skills
//                           ) {
//        return candidatService.searchByFirstNameLastNameSkills(firstName, lastName, frontend_skills);
//    }
    @GetMapping("/Hrs/search")
    @ResponseStatus(HttpStatus.OK)
    public List<CandidateDTO> search(@RequestParam(value = "firstname", required = false) String firstname,
                                     @RequestParam(value = "lastname", required = false) String lastname,
                                     @RequestParam(value = "frontend", required = false) String frontend,
                                     @RequestParam(value = "backend", required = false) String backend,
                                     @RequestParam(value = "db", required = false) String db,
                                     @RequestParam(value = "outil", required = false) String outil) {
        return candidatService.searchByFirstNameLastNameSkills(firstname, lastname, frontend, backend, db, outil);
    }
    }


