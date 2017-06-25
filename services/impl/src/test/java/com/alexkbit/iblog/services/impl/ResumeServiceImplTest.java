package com.alexkbit.iblog.services.impl;


import com.alexkbit.iblog.model.Resume;
import com.alexkbit.iblog.model.User;
import com.alexkbit.iblog.repositories.api.ResumeRepository;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Test for {@link ResumeServiceImpl}
 */
@RunWith(EasyMockRunner.class)
public class ResumeServiceImplTest extends EasyMockSupport {

    @Mock
    private ResumeRepository resumeRepository;

    @TestSubject
    private ResumeServiceImpl resumeService = new ResumeServiceImpl();

    @Test
    public void testSave() {
        Resume resume = createResume();
        expect(resumeRepository.save(anyObject(Resume.class))).andReturn(resume);
        replayAll();
        assertEquals(resume.getId(), resumeService.save(new Resume()).getId());
        verifyAll();
    }

    @Test
    public void testGet() {
        Resume resume = createResume();
        expect(resumeRepository.findOne(eq(resume.getId()))).andReturn(resume);
        replayAll();
        assertEquals(resume.getId(), resumeService.get(resume.getId()).getId());
        verifyAll();
    }

    @Test
    public void testGetActive() {
        Resume resume = createResume();
        expect(resumeRepository.findActive()).andReturn(resume);
        replayAll();
        Resume result = resumeService.getActive();
        assertEquals(resume.getId(), result.getId());
        verifyAll();
    }

    private Resume createResume() {
        Resume resume = new Resume();
        resume.setId(UUID.randomUUID().toString());
        resume.setUser(new User());
        resume.getUser().setId(UUID.randomUUID().toString());
        return resume;
    }
}