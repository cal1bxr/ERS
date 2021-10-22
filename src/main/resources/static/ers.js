const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let reimbButton = document.createElement("button");
let userButton = doucment.createElement("button");
let addReimbButton = document.getElementById("addReimbButton");
let loginButton = document.getElementById('loginButton');

reimbButton.onclick = getAllReimbs;
userButton.onclick = getAllUsers;
addReimbButton.onclick = addReimb;
loginButton.onclick = loginToApp;

reimbButton.innerText = "See All Reimbursements";
userButton.innerText = "See All Users";

async function loginToApp() {
    let user = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    }

    let response = await fetch(URL + "login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    if (response.status === 200) {
        document.getElementsByClassName("formClass")[0].innerHTML = "";
        buttonRow.appendChild(reimbButton);
        buttonRow.appendChild(userButton);
    } else {
        let para = document.createElement("p");
        para.setAttribute("style", "color:red");
        para.innerText = "LOGIN FAILED";
        document.getElementsByClassName("formClass")[0].appendChild(para);
    }
}
async function getAllReimbs() {
    let response = await fetch(URL + "reimbs", { credentials: "include" });

    if (response.status === 200) {
        let data = await response.json();
        populateReimbsTable(data);
    } else {
        console.log("There are no reimbs to show");
    }
}

function populateReimbsTable(data) {
    let tbody = document.getElementById("reimbursementBody");

    tbody.innerHTML = "";

    for (let avenger of data) {
        let row = document.createElement("tr");

        for (let cell in avenger) {
            let td = document.createElement("td");
            if (cell != "home") {
                td.innerText = avenger[cell];
            } else if (avenger[cell]) {
                td.innerText = `${avenger[cell].name}: ${avenger[cell].streetNumber} ${avenger[cell].streetName} ${avenger[cell].city } ${avenger[cell].region}, ${avenger[cell].zip} ${avenger[cell].country}`
            }
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

async function getAllUsers() {
    let response = await fetch(URL + "ersUsers", { credentials: "include" });
    if (response.status === 200) {
        let data = await response.json();
        populateUsersTable(data);
    } else {
        console.log("Usres not available.");
    }
}

function populateUsersTable(data) {
    let tbody = document.getElementById("ersUsersBody");

    tbody.innerHTML = "";

    for (let home of data) {
        let row = document.createElement("tr");
        for (let cell in home) {
            let td = document.createElement("td");
            td.innerText = home[cell];
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

//   function getUser(){
//     let newName = document.getElementById("homeName").value;
//     let newStreetNum = document.getElementById("homeStreetNum").value; 
//     let newStreetName = document.getElementById("homeStreetName").value;
//     let newCity = document.getElementById("homeCity").value;
//     let newRegion = document.getElementById("homeRegion").value;
//     let newZip = document.getElementById("homeZip").value;
//     let newCounty = document.getElementById("homeCountry").value;

//     let home =  {
//       name:newName,
//       streetNumber:newStreetNum,
//       streetName:newStreetName,
//       city:newCity,
//       region:newRegion,
//       zip:newZip,
//       country:newCounty
//     }

//     return home;
//   }

//   async function addHome(){
//     let home = getNewHome();

//     let response = await fetch(URL+"homes", {
//       method:'POST',
//       body:JSON.stringify(home),
//       credentials:"include"
//     });

//     if(response.status===201){
//       console.log("Home created successfully.");
//     }else{
//       console.log("Something went wrong creating your home.")
//     }

//   }