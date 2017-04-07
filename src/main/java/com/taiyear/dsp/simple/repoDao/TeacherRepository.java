/**
 * 
 */
package com.taiyear.dsp.simple.repoDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taiyear.dsp.simple.entity.Teacher;

/**
 * @author liul
 * 
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
