package com.alexkbit.iblog.repository.impl.jpa;


import com.alexkbit.iblog.repository.impl.entities.CertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring data repository for {@link CertificateEntity}
 */
public interface CertificateRepositoryJpa extends JpaRepository<CertificateEntity, String> {

}
