/**
 * 
 */
package com.taiyear.dsp.simple.repoDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taiyear.dsp.simple.entity.Student;

/**
 * @author liul
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByName(String name);
}
