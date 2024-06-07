
function validate(frm) {
	//empty the existing error messages
	document.getElementById("empNameError").innerHTML = "";
	document.getElementById("jobError").innerHTML = "";
	document.getElementById("salaryError").innerHTML = "";
	document.getElementById("deptNoError").innerHTML = "";

	//read the form data
	let eName = frm.empName.value;
	let eJob = frm.job.value;
	let eSalary = frm.salary.value;
	let eDeptNo = frm.deptNo.value;

	let vflag = true;

	if (eName == "") {
		document.getElementById("empNameError").innerHTML = "EmpName is required. (ClientSideError)";
		vflag = false;
	}
	else if (eName.length < 5 || eName.length > 15) {
		document.getElementById("empNameError").innerHTML = "EmpName length must be >5 Or <15. (ClientSideError)";
		vflag = false;
	}

	if (eJob == "") {
		document.getElementById("jobError").innerHTML = "Designation is required. (ClientSideError)";
		vflag = false;
	}
	else if (eJob.length < 5 || eJob.length > 15) {
		document.getElementById("jobError").innerHTML = "Designation length must be >5 Or <15. (ClientSideError)";
		vflag = false;
	}


	if (eSalary == "") {
		document.getElementById("salaryError").innerHTML = "Salary is required. (ClientSideError)";
		vflag = false;
	}
	else if (isNaN(eSalary)) {
		document.getElementById("salaryError").innerHTML = "Salary  must be Numeric Value. (ClientSideError)";
		vflag = false;
	}
	else if (eSalary < 10000 || eSalary > 200000) {
		document.getElementById("salaryError").innerHTML = "Salary  must be >10000 Or <200000. (ClientSideError)";
		vflag = false;
	}

	if (eDeptNo == "") {
		document.getElementById("deptNoError").innerHTML = "DeptNo is required. (ClientSideError)";
		vflag = false;
	}
	else if (eDeptNo < 100 || eDeptNo > 500) {
		document.getElementById("deptNoError").innerHTML = "DeptNo  must be >100 Or <500. (ClientSideError)";
		vflag = false;
	}
	
	return vflag;
}