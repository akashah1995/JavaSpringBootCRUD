package com.akashah.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akashah.crud.models.Language;


@Repository
public interface LanguageRepository extends CrudRepository <Language, Long> {

}
