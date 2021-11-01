const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let reimbButton = document.createElement("button");
let userButton = document.createElement("button");
let addReimbButton = document.getElementById("addReimbButton");
let loginButton = document.getElementById('loginButton');
let getUserButton = document.getElementById('getUserNameButton')
let reimbursementButton = document.getElementById('getReimbursementNumber');
let submitButton = document.getElementById('submitReimb');
let logoutButton = document.getElementById('logout');
let pastReimbursementButton = document.getElementById('View Past Reimbursements')

reimbButton.onclick = getAllReimbs;
userButton.onclick = getAllUsers;
addReimbButton.onclick = addReimb;
loginButton.onclick = loginToApp;
reimbursementButton.onclick = approveDeny;
// submitButton.onclick = submitUpdate;
logoutButton.onclick = logout;
// pastReimbursementButton.onclick = getPastTickets;



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

function logout(){
    sessionStorage.clear();
}

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
       
        getUsername();
            // if(ersUsersRole.userRoleId == 1){
            //     buttonRow.appendChild(div);
            // } else{
            //     buttonRow.appendChild(otherDiv);
            // }
        let userLogin = sessionStorage.getItem('user');
        userParsed = JSON.parse(userLogin);
        console.log(userParsed);
            document.getElementsByClassName("formClass")[0].innerHTML = "";
            buttonRow.appendChild(reimbButton);
            buttonRow.appendChild(userButton);
            buttonRow.appendChild(addReimbButton);
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

function convertTimestamp(timeStamp){
    var date = new Date(timeStamp);

    return date;
}

function populateReimbsTable(data) {
    let tbody = document.getElementById("reimbursementBody");
    console.log(data)
    

    tbody.innerHTML = "";

    for (let reimb of data) {
        let row = document.createElement("tr");

        for (let cell in reimb) {
            let td = document.createElement("td");
                td.innerText = reimb[cell];
                if((cell=="reimbAuthor" ||cell=="reimbResolver")&&reimb[cell]){
                    td.innerText = reimb[cell].ersUserName;
                }else if(cell=="reimbStatusId"&&reimb[cell]){ 
                    td.innerText = `${reimb[cell].reimbStatus}`
                }else if(cell=="reimbTypeId"&&reimb[cell]){
                    td.innerText = `${reimb[cell].reimbType}`
                }else if((cell=="reimbSubmitted"||cell=="reimbResolved")&&reimb[cell]){
                    td.innerText = `${convertTimestamp(reimb[cell])}`
                }else if(reimb[cell]){
                    td.innerText = `${reimb[cell]}`
                }
                  row.appendChild(td);
            }
            
    
        tbody.appendChild(row);
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

        reimbSubmitted: newReimbSubmitted,
        
        // reimbDescription: newReimbDescr,
        reimbAuthor : newAuthor,
        reimbStatusId : REIMBSTATUSPENDING,
        reimbTypeId : newReimbType
        
    }
        // reimbDescr: newReimbDescr,

        // reimbType: newReimbType
    return reimb;

}


// function updatedReimb(){
//     if(document.getElementById("approved")){
//         reimbStatusId = REIMBSTATUSAPPROVED;
//     } else {
//         reimbStatusId = REIMBSTATUSDENIED;
//     }

//     console.lot(reimbStatusId);
// }

// async function approveDenyReimb(){
//     let reimb = updatedReimb();
//     let response = await fetch(URL + "reimbs", {
//         method: 'PUT',
//         body: JSON.stringify(reimb),
//         credentials: "include"
//     });

//     if(response.status === 200){
//         let data = await response.json();
//         console.log(data)
//     }
// }

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
            if (cell != "reimbAuthor") {
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

