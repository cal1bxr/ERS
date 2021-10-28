const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let reimbButton = document.createElement("button");
let userButton = document.createElement("button");
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

    for (let reimb of data) {
        let row = document.createElement("tr");

        for (let cell in reimb) {
            let td = document.createElement("td");
            if (cell != "user") {
                td.innerText = reimb[cell];
            } else if (reimb[cell]) {
                td.innerText = `${reimb[cell].reimbId}: ${reimb[cell].reimbAmount}, ${reimb[cell].reimbSubmitted}, ${reimb[cell].reimbResolved}, ${reimb[cell].reimbDescr}, ${reimb[cell].reimbAuthor}, ${reimb[cell].reimbResolver}, ${reimb[cell].reimbStatus}, ${reimb[cell].reimbType}`
            }
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

function getNewReimb() {
    let newReimbAmount = document.getElementById("reimbursementAmount").value;
    // let newReimbDescr = document.getElementById("roleId").value;
    // let newReimbReceipt = document.getElementById().value;
    // let newReimbType = document.getElementById("reimbursementType").value;


    let reimb = {

        reimbAmount: newReimbAmount
 
 
        // reimbDescr: newReimbDescr,

        // reimbType: newReimbType
    }

    return reimb;
}

async function addReimb() {
    let reimb = getNewReimb();

    let response = await fetch(URL + "reimbs", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials: "include"
    });

    if (response.status === 201) {
        console.log("User created successfully.");
    } else {
        console.log("Something went wrong creating your user.")
    }

}

async function getAllUsers() {
    let response = await fetch(URL + "ersUsers", { credentials: "include" });
    if (response.status === 200) {
        let data = await response.json();
        console.log(data);
        populateUsersTable(data);
    } else {
        console.log("Users not available.");
    }
}

function populateUsersTable(data) {
    let tbody = document.getElementById("ersUsersBody");

    tbody.innerHTML = "";

    for (let user of data) {
        let row = document.createElement("tr");
        for (let cell in user) {
            let td = document.createElement("td");
            td.innerText = user[cell];
            // td.innerText = `${user[cell].name}: ${user[cell].userFirstName}, ${user[cell].userLastName}, ${user[cell].userEmail}, ${user[cell].userRoleId}`;

            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

function getNewHome() {
    let newName = document.getElementById("homeName").value;
    let newStreetNum = document.getElementById("homeStreetNum").value;
    let newStreetName = document.getElementById("homeStreetName").value;
    let newCity = document.getElementById("homeCity").value;
    let newRegion = document.getElementById("homeRegion").value;
    let newZip = document.getElementById("homeZip").value;
    let newCounty = document.getElementById("homeCountry").value;

    let home = {
        name: newName,
        streetNumber: newStreetNum,
        streetName: newStreetName,
        city: newCity,
        region: newRegion,
        zip: newZip,
        country: newCounty
    }

    return home;
}