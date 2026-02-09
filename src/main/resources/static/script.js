const API_URL = "http://localhost:8080";

//   GET ALL STUDENTS 
async function get(event) {
	
    try { 
        const response = await fetch(`${API_URL}/get`);
        const students = await response.json();       
		const tableBody = document.getElementById("student-data-table"); 
        
        if (tableBody) {
            tableBody.innerHTML = "";
            students.forEach(s => {
                tableBody.innerHTML += `
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.lname}</td>
                        <td>${s.age}</td>       
                    </tr>`;
            });
        }
		
				     // window.location.href = "result.html"; // after submit go to result page
		   
		   
    } catch (error) {
        console.error("Error fetching students:", error);
    }
}

//  ADD STUDENT 
async function addStudent(event) {
    event.preventDefault();
    const data = {
        name: document.getElementById("name").value,
        lname: document.getElementById("lname").value,
        age: parseInt(document.getElementById("age").value)
    };

    const response = await fetch(`${API_URL}/addstudent`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    });

    if(response.ok) {
        alert("add completly");
        window.location.href = "result.html"; 
    }
}

//  UPDATE STUDENT
async function updateStudent(event) {
    event.preventDefault();
   
	 const id = document.getElementById("roll-no").value; 
   
	 const data = {
        name: document.getElementById("name").value,
        lname: document.getElementById("lname").value,
        age: parseInt(document.getElementById("age").value)
    };

    const response = await fetch(`${API_URL}/update/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    });

    if(response.ok) {
        alert("data updated");
        window.location.href = "result.html"; 
    } else {
        alert("ID NOT FOUND!!");
    }
}

//  DELETE STUDENT 
async function deleteStudent(event) {
    if(event) event.preventDefault();
    const id = document.getElementById("del-roll-no").value;

    if(confirm("This is Final ?")) {
        const response = await fetch(`${API_URL}/delete/${id}`, { method: "DELETE" });
        if(response.ok) {
            alert("Student data deleted.");
            window.location.href = "result.html"; 
        } else {
            alert("ID not present...");
        }
    }
}