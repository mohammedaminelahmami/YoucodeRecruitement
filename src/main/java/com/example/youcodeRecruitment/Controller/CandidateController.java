package com.example.youcodeRecruitment.Controller;

import com.example.youcodeRecruitment.Request.CandidateRequest;
import com.example.youcodeRecruitment.Service.CandidateService;
import com.example.youcodeRecruitment.dto.CandidateDTO;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@MultipartConfig
@RequestMapping("/api/v1/")
public class CandidateController {
    private final CandidateService candidateService;

    // method update candidate
    @PutMapping("/candidate/{id}") // idCandidate
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable String id, @RequestBody CandidateRequest candidateRequest) {
        candidateService.updateCandidate(candidateRequest, Long.parseLong(id));
    }

    @PostMapping("/candidateImage")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateImage(@RequestParam(value = "id") Long id, @RequestParam("imageFile") MultipartFile imageFile) {
        candidateService.updateCandidateImage(id, imageFile);
    }

    // method delete candidate
    @DeleteMapping("/candidate/{id}") // idCandidate
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        candidateService.deleteCandidate(Long.parseLong(id));
    }

    // method get one candidate
    @GetMapping("/candidate/{id}") // idCandidate
    @ResponseStatus(HttpStatus.OK)
    public CandidateDTO getOne(@PathVariable String id) {
        return candidateService.getOneCandidate(Long.parseLong(id));
    }

    // method get all candidates
    @GetMapping("/candidates")
    @ResponseStatus(HttpStatus.OK)
    public List<CandidateDTO> getAllById(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit) {
        return candidateService.getAllCandidates(page, limit);
    }
}
