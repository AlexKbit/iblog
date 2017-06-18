package com.alexkbit.iblog.repository.impl.utils;


import com.alexkbit.iblog.repository.impl.entities.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Utility for data Specifications
 */
public class SearchSpecificationsUtils {

    /**
     * Quote.
     */
    static final String QUOTE = "\"";

    public static <T extends BaseEntity> Specification<T> searchSpecification(final String searchQuery, final String field) {

        return (root, criteriaQuery, cb) -> {
            Predicate searchPredicate = buildSearchPredicate(searchQuery, root.get(field), cb);
            if (searchPredicate == null) {
                return null;
            }
            return cb.and(searchPredicate);
        };
    }

    private static Predicate buildSearchPredicate(String searchQuery, Expression<String> searchField, CriteriaBuilder cb) {
        if (searchQuery == null || searchQuery.isEmpty()) {
            return null;
        }
        searchQuery = searchQuery.toLowerCase().replace(QUOTE, "");
        return cb.like(cb.lower(searchField), "%" + searchQuery + "%");
    }
}
