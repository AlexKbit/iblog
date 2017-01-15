/*
 * Copyright (c) T-Systems International, 2016
 * The copyright of the computer program herein is the property of
 * T-Systems International. The program may be used and/or copied
 * only with the written permission of T-Systems International or in
 * accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program has been supplied.
 *
 * Created by dKobylki on 6/28/16 4:34 PM.
 */

package com.alexkbit.iblog.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot application for test repositories
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.alexkbit.iblog")
public class RepositoryTestApplication {
}
