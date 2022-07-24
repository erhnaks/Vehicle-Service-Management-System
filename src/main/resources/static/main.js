"use strict";

let chosenVehicleId = null; //Update functional purpose!

function closeVehicleModal(){ //This function will close the modal after successful save.   
    const modalElement = document.getElementById("vehicleModal"); 
    const modal = bootstrap.Modal.getInstance(modalElement);
    modal.hide(); //Modal is hiddened after a successful creation.
//Below line is to re-assigned fields value to an empty string so the modal fields returns blank.
    document.getElementById("vrm").value = ""; 
    document.getElementById("mileage").value = "";
    document.getElementById("description").value = "";
    document.getElementById("cost").value = "";

    document.getElementById('submitButton').innerHTML = "Save";
    chosenVehicleId = null;
}

function submitForm(){

  if (!chosenVehicleId) return createService(); 
  else updateVehicle(chosenVehicleId); //onclick will initiate update function;


}
// Below function is to save time and call this function when the vehicle entity is called.
function writeServiceRow(vehicle) {
  const vehicleUpdate = encodeURIComponent(JSON.stringify(vehicle)); //Encoding the data for the Update payload;
  return `
  <tr id="row-${vehicle.id}">
    <td>${vehicle.id}</td>
    <td>${vehicle.vrm}</td>
    <td>${vehicle.mileage}</td>
    <td>${vehicle.description}</td>
    <td>${vehicle.cost}</td>
    <td class="w-25">
      <button class="UpdateButton" data-bs-toggle="modal" data-bs-target="#vehicleModal"
      onclick="fillFormForUpdate('${vehicleUpdate}')">Update</button>
      <button class="DeleteButton" onclick="deleteVehicle('${vehicle.id}')">Delete</button>
    </td>
  </tr>
`;
}

// Below lines are used to reload the modal fields with the vehicle data when the the user click on update button.
function fillFormForUpdate(vehiclePayload) {
  document.getElementById('submitButton').innerHTML = "Update";

  const vehicle = JSON.parse(decodeURIComponent(vehiclePayload)); //Decoding the data for update pre-filled Modal;
  // Below lines will payload the Modal when update button is clicked! Makes it easier to update desired fields!

  document.getElementById('vrm').value = vehicle.vrm;
  document.getElementById('mileage').value = vehicle.mileage;
  document.getElementById('description').value = vehicle.description;
  document.getElementById('cost').value = vehicle.cost;

  chosenVehicleId = vehicle.id;
}



async function createService() {
  const vrm = document.getElementById("vrm").value;
  const mileage = document.getElementById("mileage").value;
  const description = document.getElementById("description").value;
  const cost = document.getElementById("cost").value;

  const { data : vehicles} = await axios.post('http://localhost:8080/create', { vrm, mileage, description, cost });  

  const vehicle = { id: vehicles.id , vrm, mileage, description, cost };

  const appendData = writeServiceRow(vehicle);

  const tableBody = document.getElementById("table-body");
  tableBody.innerHTML += appendData;

  closeVehicleModal();
}

async function updateVehicle() {

const vrm = document.getElementById('vrm').value;
const mileage = document.getElementById('mileage').value;
const description = document.getElementById('description').value;
const cost = document.getElementById('cost').value;


await axios({
  method: "put",
  url: "http://localhost:8080/update/" + chosenVehicleId,
  data: { vrm, mileage, description, cost }
});

const vrmField = document.querySelector( '#row-' + chosenVehicleId + " td:nth-child(2)" ); //Selecting the child <tr> elements after the id>
const mileagefield = document.querySelector( '#row-' + chosenVehicleId + " td:nth-child(3)" );
const descriptionField = document.querySelector( '#row-' + chosenVehicleId + " td:nth-child(4)" );
const costField = document.querySelector( '#row-' + chosenVehicleId + " td:nth-child(5)" );
const updateButtonField = document.querySelector("#row-" + chosenVehicleId + " td:nth-child(6) button:nth-child(1)");

const vehicleUpdate = encodeURIComponent(JSON.stringify({id: chosenVehicleId, vrm, mileage, description, cost}));

updateButtonField.setAttribute('onclick', 'fillFormForUpdate("' + vehicleUpdate + '")'); 
// UpdateButtonfield function is to reload the updated data onto modal fields.


vrmField.innerHTML = vrm;
mileagefield.innerHTML = mileage;
descriptionField.innerHTML = description;
costField.innerHTML = cost;

closeVehicleModal();
}

async function deleteVehicle(vehicleId) {
await axios.delete("http://localhost:8080/remove/" + vehicleId);


const userElement =  document.getElementById("row-" + vehicleId);
userElement.remove();

}



async function loadvehicles() {
  let tableBodyContent = "";

  const { data : vehicles} = await axios.get('http://localhost:8080/getAll') //Fetching Object from Axios then returning DATA;
// After reconstructing data this line returns it to vehicles;
  vehicles.forEach(vehicles => (tableBodyContent += writeServiceRow(vehicles)));

  const tableBody = document.getElementById("table-body");
  tableBody.innerHTML = tableBodyContent;
}

loadvehicles();
