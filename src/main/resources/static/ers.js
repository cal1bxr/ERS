const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let reimbButton = document.createElement("button");
let userButton = document.createElement("button");
let addReimbButton = document.getElementById("addReimbButton");
let loginButton = document.getElementById('loginButton');
let getUserButton = document.getElementById('getUserNameButton')
let reimbursementButton = document.getElementById('getReimbursementNumber');
let submitButton = document.getElementById('submitReimb');

reimbButton.onclick = getAllReimbs;
userButton.onclick = getAllUsers;
addReimbButton.onclick = addReimb;
loginButton.onclick = loginToApp;
reimbursementButton.onclick = approveDeny;
submitButton.onclick = submitUpdate;


reimbButton.innerText = "See All Reimbursements";
userButton.innerText = "See All Users";

var username;

const REIMBSTATUSPENDING ={
    'reimbStatus': 'PENDING',
    'reimbStatusId' : '1'
};
const REIMBSTATUSAPPROVED ={
    'reimbStatus': 'APPROVED',
    'reimbStatusId' : '2'
}; 
const REIMBSTATUSDENIED ={
    'reimbStatus': 'DENIED',
    'reimbStatusId' : '3'
};
const REIMBTYPELODGING = {
    'reimbTypeId': '1',
    'reimbType': 'LODGING'
};
const REIMBTYPEFOOD = {
    'reimbTypeId': '2',
    'reimbType': 'FOOD'
};
const REIMBTYPETRAVEL = {
    'reimbTypeId': '3',
    'reimbType': 'TRAVEL'
};
const REIMBTYPEOTHER = {
    'reimbTypeId': '4',
    'reimbType': 'OTHER'
};

async function loginToApp() {
    let user = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    }
    // getErsUsername();

    let response = await fetch(URL + "login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    username = user;

    if (response.status === 200) {
        document.getElementsByClassName("formClass")[0].innerHTML = "";
        buttonRow.appendChild(reimbButton);
        buttonRow.appendChild(userButton);
        getUsername();
            // if(ersUsersRole.userRoleId == 1){
            //     buttonRow.appendChild(div);
            // } else{
            //     buttonRow.appendChild(otherDiv);
            // }
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
        console.log(data);
    } else {
        console.log("There are no reimbs to show");
    }
}

function populateReimbsTable(data) {
    let tbody = document.getElementById("reimbursementBody");
    

    tbody.innerHTML = "";

    for (let reimb of data) {
        let row = document.createElement("tr");
        timeStamp = new Date();
        console.log(timeStamp);

        for (let cell in reimb) {
            let td = document.createElement("td");
                td.innerText = reimb[cell];
                row.appendChild(td);
            }
    
        tbody.appendChild(row);

        /* for(let cell in reimb){             //create each cell
            let td = document.createElement("td"); 
            td.innerText = reimb[cell];
            row.appendChild(td);            //appends datacell to row
            if((cell=="resolver" ||cell=="author")&&reimb[cell]){
                td.innerText = reimb[cell].userId;
            }else if(cell=="status"&&reimb[cell]){//if null: false. else true. 
                td.innerText = `${reimb[cell].status}  `
            }else if(cell=="type"&&reimb[cell]){//if null: false. else true. 
                td.innerText = `${reimb[cell].type}  `
            }else if((cell=="submitted"||cell=="resolved")&&reimb[cell]){//if null: false. else true. 
                
                td.innerText = `${convertTimestamp(reimb[cell])}  `
            }else if(cell=="receipt"&&reimb[cell]){//if null: false. else true. 
                td.innerText = `${reimb[cell]}  `
            }else if(reimb[cell]){
                td.innerText = `${reimb[cell]}  `
            }
        }
        tbody.appendChild(row);     //appends the row after previous row in table
    }*/
    }
}

function getNewReimb() {
    let newAuthor = JSON.parse(sessionStorage.user);
    console.log(newAuthor);
  
   
    // let newAuthor = {
    //     "ersUsersId" : "5",
    //     "ersUsername": "mjon",
    //     "ersPassword": "password",
    //     "ersFirstName": "Matt",
    //     "ersLastName": "Jordan",
    //     "ersEmail": "m@mjordan",
    //     "ersUserRole": {
    //         "userRoleId": 1,
    //         "userRole": "ADMIN"
    //     }
    // };

    let newReimbAmount = document.getElementById("reimbursementAmount").value;
    let newReimbSubmitted = new Date();
    // let newReimbAuthor = newAuthor;
    // let newReimbDescr = document.getElementById("reimbursementDescription");
    // let newReimbAuthor = document.getElementById("reimbursementAuthor").value;
    // let newReimbReceipt = document.getElementById().value;
    let typeChoice = document.getElementById("reimbursementType").value;
        switch( typeChoice.toUpperCase()) {
            case 'LODGING':
                newReimbType = REIMBTYPELODGING;
                break;
            case 'FOOD':
                newReimbType = REIMBTYPEFOOD;
                break;
            case 'TRAVEL':
                newReimbType = REIMBTYPETRAVEL;
                break;
            case 'OTHER':
            newReimbType = REIMBTYPEOTHER;
                break;
        }
        console.log(newAuthor);



    let reimb = {

        reimbAmount: newReimbAmount,
        reimbAuthor: newAuthor,
        reimbSubmitted: newReimbSubmitted,
        
        // reimbDescription: newReimbDescr,
        reimbAuthor : newAuthor,
        reimbStatusId : REIMBSTATUSPENDING,
        reimbTypeId : newReimbType
        
    }
        // reimbDescr: newReimbDescr,

        // reimbType: newReimbType
    return reimb;


};

function updatedReimb(){
    if(document.getElementById("approved")){
        reimbStatusId = REIMBSTATUSAPPROVED;
    } else {
        reimbStatusId = REIMBSTATUSDENIED;
    }

    console.lot(reimbStatusId);
}

async function approveDenyReimb(){
    let reimb = updatedReimb();
    let response = await fetch(URL + "reimbs", {
        method: 'PUT',
        body: JSON.stringify(reimb),
        credentials: "include"
    });

    if(response.status === 200){
        let data = await response.json();
        console.log(data)
    }
}

async function addReimb() {
    let reimb = getNewReimb();
    console.log(reimb);

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
            if (cell != "ersUserRole") {
                td.innerText = user[cell];
                // td.innerText = `${user.ersUsersId}: ${user.ersUsername}, ${user.ersFirstName}, ${user.ersLastName}, ${user.ersEmail}`;
            } else if (user[cell]) {
                td.innerText = `${user[cell].userRole}`;
            }
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

function getNewUser() {
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

async function getUsername() {
    console.log(username.username);
    let response = await fetch(URL + `ersUsers/${username.username}`, { credentials: "include" }); //   /ersuser/mjordan
    if (response.status === 200) {
        let data = await response.json();
        console.log(data);
        sessionStorage.setItem('user', JSON.stringify(data));

        return data;
        
    } else {
        console.log("Users not available.");
    }
}

async function getPastTickets(){
    reimb = sessionStorage.getItem('user');
    reimbParsed = JSON.parse(reimb);
    console.log(reimbParsed);
    let tickets = reimbParsed.ersUsersId;
    console.log(tickets);
    let response = await fetch(URL + `reimbs/${tickets}`, {credentials: "include"});
    if (response.status === 200){
        let data = await response.json();
        console.log(data);
        
        return data;

    } else {
        console.log("No reimbursment exists");
    }
}

async function approveDeny(){
    ticket = document.getElementById("reimbursementNumber").value;
    let response = await fetch(URL + `reimb/${ticket}`, {credenetials: "include"});
    if(response.status === 200){
        let data = await response.json();
        console.log(data.reimbStatusId);
            if(document.getElementById("reimbursementApproved") === "Approved"){
                data.reimbStatusId = REIMBSTATUSAPPROVED;
            } else if (document.getElementById("reimbursementApproved") === "Denied"){
                data.reimbStatusId = REIMBSTATUSDENIED;
            }
    } else {
        console.log("No reimb found");
    }

    sessionStorage.setItem("status", "data.reimbStatusId");
}

async function submitUpdate(){
    let response = await fetch(URL + '/reimbs', {
        method: 'POST',
        body: JSON.stringify(data.reimbStatusId),
        credentials: "include"
    });
    if(response.status === 200){
        console.log("Reimb updated");
    } else {
        console.log("update failed");
    }
}






