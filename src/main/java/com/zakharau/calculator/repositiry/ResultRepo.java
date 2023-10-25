package com.zakharau.calculator.repositiry;

import com.zakharau.calculator.entity.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends CrudRepository<Result, Long> {

}
