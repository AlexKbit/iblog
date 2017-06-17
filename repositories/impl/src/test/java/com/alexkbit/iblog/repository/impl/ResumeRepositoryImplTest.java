package com.alexkbit.iblog.repository.impl;


import com.alexkbit.iblog.model.Certificate;
import com.alexkbit.iblog.model.Resume;
import com.alexkbit.iblog.model.Technology;
import com.alexkbit.iblog.model.WorkPosition;
import com.alexkbit.iblog.repositories.api.ResumeRepository;
import com.alexkbit.iblog.repositories.api.UserRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Repository test for {@link ResumeRepositoryImpl}
 */
@DatabaseSetup(value = {
        "/datasets/repositories/user/user_three.xml",
        "/datasets/repositories/image/image_four.xml",
        "/datasets/repositories/resume/resume_one.xml"})
public class ResumeRepositoryImplTest extends AbstractTestRepository {

    private static final String USER_UUID = "8ac8087d-fc14-4e4f-b9d0-5c4b9e05a501";

    private static final String RESUME_UUID = "4ac8087d-fc14-4e4f-b9d0-5c4b9e05a001";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResumeRepository resumeRepository;


    @Test
    public void testSave() {
        Resume resume = new Resume();
        resume.setUser(userRepository.findOne(USER_UUID));
        resume.setAboutMe("text");
        Technology t = new Technology();
        t.setName("Java");
        resume.setTechnologies(Arrays.asList(t));
        resume.setCertificates(Arrays.asList(new Certificate()));
        resume.setPositions(Arrays.asList(new WorkPosition()));

        Resume newResume = resumeRepository.save(resume);
        assertNotNull(newResume.getId());
        assertNotNull(newResume.getCreatedAt());
        assertNotNull(newResume.getUpdatedAt());
        assertEquals(resume.getCertificates().size(), newResume.getCertificates().size());
        assertEquals(resume.getPositions().size(), newResume.getPositions().size());
        assertEquals(resume.getTechnologies().size(), newResume.getTechnologies().size());
        assertEquals(resume.getAboutMe(), newResume.getAboutMe());
    }

    @Test
    public void testGetByUserId() {
        Resume resume = resumeRepository.getByUserId(USER_UUID);
        assertEquals(RESUME_UUID, resume.getId());
        assertEquals(2, resume.getTechnologies().size());
        assertEquals(1, resume.getCertificates().size());
        assertEquals(1, resume.getPositions().size());
    }
}