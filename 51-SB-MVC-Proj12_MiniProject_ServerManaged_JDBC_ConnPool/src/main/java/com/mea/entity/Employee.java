package com.mea.entity;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BOOT_EMP")
@Data
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='DELETED' WHERE EMP_NO=?")
//@Where(clause = "STATUS <> 'DELETED'") //deprecated
@SQLRestriction("STATUS <> 'DELETED'")
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1" , sequenceName = "emp_seq1" , initialValue = 1000)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empNo;
	private String empName;
	private String job="CLERK";
	private Double salary;
	private Integer deptNo;
	private String status="active";
}
