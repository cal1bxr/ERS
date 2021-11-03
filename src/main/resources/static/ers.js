const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let addReimbButton = document.getElementById("addReimbButton");
let loginButton = document.getElementById('loginButton');



let getUserButton = document.getElementById('getUserNameButton');
let reimbursementButton = document.getElementById('getReimbursementNumber');
let getReimbursementButton = document.getElementById('getReimbursementButton')
let getPreviousTickets = document.getElementById('getprevReimbursements');




let logoutButton = document.getElementById('logout');


let submitReimbursementButton = document.getElementById('appDenyReimbursement');


let reimbButton = document.createElement("button");
let userButton = document.createElement("button");



reimbButton.onclick = getAllReimbs;
userButton.onclick = getAllUsers;
addReimbButton.onclick = addReimb;
loginButton.onclick = loginToApp;
getReimbursementButton.onclick = getOneReimbursement;
submitReimbursementButton.onclick = approveDenyReimb;
logoutButton.onclick = logout;
getPreviousTickets.onclick = getPastTickets;


reimbButton.innerText = "See All Reimbursements";
userButton.innerText = "See All Users";

var username;

const REIMBSTATUSPENDING ={
    'reimbStatus': 'PENDING',
    'reimbStatusId' : '2'
};
const REIMBSTATUSAPPROVED ={
    'reimbStatus': 'APPROVED',
    'reimbStatusId' : '1'
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

/*------------------------------------------------Log In and Out Logic------------------------------------------------- */


function logout(){
    sessionStorage.clear();
}

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

    username = user;
    
    if (response.status === 200) {
      
       getUsername();
        // setEnvironment();
    } else {
        let para = document.createElement("p");
        para.setAttribute("style", "color:red");
        para.innerText = "LOGIN FAILED";
        document.getElementsByClassName("formClass")[0].appendChild(para);
    }
}

function setEnvironment(){
    let userParsed = JSON.parse(sessionStorage.getItem('user'));
    let userLogin = userParsed.ersUserRole.userRoleId;
        if(userLogin === 1){
            document.getElementsByClassName("formClass")[0].innerHTML = "";
            buttonRow.appendChild(reimbButton);
            buttonRow.appendChild(userButton);
            buttonRow.appendChild(addReimbButton);
        } else {
            buttonRow.appendChild(getPreviousTickets);
            buttonRow.appendChild(addReimbButton);
        }
        

/*------------------------------------------------Get Reimbursements and Users Logic------------------------------------------------- */



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
    
    tbody.innerHTML = "";

    for (let reimbs of data) {
        let row = document.createElement("tr");

        for (let cell in reimbs) {
            let td = document.createElement("td");
                td.innerText = reimbs[cell];
                console.log(reimbs[cell]);
                if((cell=="reimbAuthor") && reimbs[cell]){
                    console.log(reimbs.reimbAuthor.ersUsername);
                    td.innerText = `${reimbs.reimbAuthor.ersUsername}`;   
                } else if(cell=="reimbResolver" && reimbs[cell]){
                    if(cell=="reimbResolver" && reimbs[cell]){
                    td.innerText = `${reimbs.reimbResolver.ersUsername}`;
                    } else {
                        td.innerText = 'null';
                    }
                } else if(cell=="reimbStatusId" && reimbs[cell]){ 
                    td.innerText = `${reimbs[cell].reimbStatus}`;
                }else if(cell=="reimbTypeId" && reimbs[cell]){
                    td.innerText = `${reimbs[cell].reimbType}`;
                }else if((cell=="reimbSubmitted"||cell=="reimbResolved") && reimbs[cell]){
                    td.innerText = `${convertTimestamp(reimbs[cell])}`;
                }else if(reimbs[cell]){
                    td.innerText = `${reimbs[cell]}`;
                }
                  row.appendChild(td);
            }
            
        tbody.appendChild(row);
    }
}


function getNewReimb() {
    let newAuthor = JSON.parse(sessionStorage.user);  
    
    let newReimbAmount = document.getElementById("reimbursementAmount").value;
    let newReimbSubmitted = new Date();
    let newReimbDescr = document.getElementById("reimbursementDescription").value;
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

    let reimb = {

        reimbAmount: newReimbAmount,
        reimbSubmitted: newReimbSubmitted,
        reimbDescription: newReimbDescr,
        reimbReceipt: null,
        reimbAuthor : newAuthor,
        reimbStatusId : REIMBSTATUSPENDING,
        reimbTypeId : newReimbType
    }
    return reimb;

}

async function getOneReimbursement(){
    let reimbId = document.getElementById("reimbursementNumber").value;
    console.log(reimbId);
    let ticket = reimbId;
    let response = await fetch(URL + `reimbs/${ticket}`, {credentials: "include"});
    if(response.status === 200){
        let data = await response.json();
        console.log(data);
        populateReimbsTable(data);

        return data;
    } else {
        console.log("Soemthing went wrong");
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
            } else if (cell == "ersPassword"){
                td.innerText == '';
            } else if (user[cell]) {
                td.innerText = `${user[cell].userRole}`;
            }
            row.appendChild(td);
        }
        tbody.appendChild(row);
}
}

async function getUsername() {
    let response = await fetch(URL + `ersUsers/${username.username}`, { credentials: "include" }); 
    if (response.status === 200) {
        let data = await response.json();
        console.log(data);
        sessionStorage.setItem('user', JSON.stringify(data));
        setEnvironment();
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
    let response = await fetch(URL + `reimbs/${userId}`, {credentials: "include"});
    if (response.status === 200){
        let data = await response.json();
        console.log(data);
        populateReimbsTable(data);

        return data;
    } else {
        console.log("No reimbursment exists");
    }
}

/*------------------------------------------------Update Reimbursement Logic------------------------------------------------- */




async function approveDenyReimb(){
    let reimb = getPastTickets();
    console.log(reimb);
    let typedReimbId = document.getElementById("approveNumber").value;
    let resolvedBy = JSON.parse(sessionStorage.user);
    console.log(resolvedBy);
    let newReimbResolved = new Date();
    let newReimbStatusId = REIMBSTATUSPENDING;
    // let selection = document.getElementById('appDenyReimbursment').onclick = function() {
    //     var e = document.getElementById("approvedDenyReimbursement");
    //     var value = e.options[e.selectedIndex].value;
    //     return value;
    // }
    let selection = document.getElementById("approvedDenyReimbursement").value;
    switch(selection.toUpperCase){
        case 'APPROVED':
             newReimbStatusId = REIMBSTATUSAPPROVED;
            break;
        case 'DENIED':
            newReimbStatusId = REIMBSTATUSDENIED;
            break;
    }

    
    

    // let reimb = {
    //     reimbId: typedReimbId,
    //     reimbResolved: newReimbResolved,
    //     reimbResolver: resolvedBy,
        
    //     reimbStatusId: newReimbStatusId,
       
   
    console.log(reimb);
    let response = await fetch(URL + "reimbs/reimb", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials: "include"
    });
        if(response.status === 200){
            console.log(reimb);
            console.log("Reimbursment update");
        } else {
         console.log("Soemthing went wrong");
         console.log(reimb);
        } 
        // console.log(data);
        //     let response2 = await fetch(URL + "reimbs/reimb", {
        //         method: 'POST',
        //         body: JSON.stringify(reimb),
        //         credentials: "include"
        //         });

    }

/*------------------------------------------------Add Reimbursement Logic------------------------------------------------- */


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


/*------------------------------------------- Filter By Status ---------------------------------*/

async function getByStatus(){
        let response = await fetch(URL + `reimbs/${statusId}`, {credentials:"include"});

        if(response.status===200){
            let data = await response.json();
            // console.log(data);
            populateReimbTable(data);
            // return data;
        } else {
        console.log("Reimbursements not available");
    }
}


