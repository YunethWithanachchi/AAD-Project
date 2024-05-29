// Frontend and backend Data Handling

var baseUrl = "http://localhost:8084/travelPlanning/vehicle";

loadAllVehicle();

$("#btnSaveVehicle").click(function () {
  saveVehicle();
});

function saveVehicle() {
  const formData = new FormData();

  const brand = $("#brand").val();
  const category = $("#category").val();
  const vehicleType = $("#vehicleType").val();
  const fuelType = $("#fuelType").val();
  const ishybrid = $("#ishybrid").val();
  const isAuto = $("#isAuto").val();
  const fuelUsage = $("#fuelUsage").val();
  const noOfSeat = $("#noOfSeat").val();
  const feeForDay = $("#feeForDay").val();
  const feeFor1km = $("#feeFor1km").val();
  const driverName = $("#driverName").val();
  const driverContact = $("#driverContact").val();
  const remark = $("#remark").val();
  const sideimg = $("#input-file1")[0].files[0];
  const frontimg = $("#input-file2")[0].files[0];
  const backimg = $("#input-file3")[0].files[0];
  const frontInterior = $("#input-file4")[0].files[0];
  const backInterior = $("#input-file5")[0].files[0];
  const licenseF = $("#input-file6")[0].files[0];
  const licenseB = $("#input-file7")[0].files[0];

  formData.append("brand", brand);
  formData.append("category", category);
  formData.append("vehicleType", vehicleType);
  formData.append("fuelType", fuelType);
  formData.append("is_hybrid", ishybrid);
  formData.append("fuel_Usage", isAuto);
  formData.append("is_auto", fuelUsage);
  formData.append("no_of_seat", noOfSeat);
  formData.append("fee_for_day", feeForDay);
  formData.append("fee_for_1km", feeFor1km);
  formData.append("driver_name", driverName);
  formData.append("driver_contact", driverContact);
  formData.append("remark", remark);
  formData.append("side_img", sideimg);
  formData.append("front_img", frontimg);
  formData.append("back_img", backimg);
  formData.append("front_interior", frontInterior);
  formData.append("back_interior", backInterior);
  formData.append("license_f_img", licenseF);
  formData.append("license_b_img", licenseB);

  $.ajax({
    url: baseUrl,
    processData: false,
    contentType: false,
    cache: false,
    method: "POST",
    data: formData,
    success: function (res) {
      if (res.code == 200) {
        alert(res.message);
      }
    },
    error: function (ob) {
      alert(ob.responseJSON.message);
    },
  });
}

function loadAllVehicle() {
  $("#tblVehicle").empty();

  $.ajax({
    url: baseUrl,
    processData: false,
    contentType: false,
    cache: false,
    method: "GET",
    success: function (res) {
      for (const vehicle of res.data) {
        let row = `<tr>

        <td class="px-4 text-center">${vehicle.vehicleId}</td>
        <td class="px-4 text-center">${vehicle.brand}</td>
        <td class="px-4 text-center">${vehicle.category}</td>
        <td class="px-4 text-center">${vehicle.vehicleType}</td>
        <td class="px-4 text-center">${vehicle.fuelType}</td>
        <td class="px-4 text-center">${vehicle.is_hybrid}</td>
        <td class="px-4 text-center">${vehicle.fuel_usage}</td>
        <td class="px-4 text-center">${vehicle.is_auto}</td>
        <td class="px-4 text-center">${vehicle.no_of_seat}</td>
        <td class="px-4 text-center">${vehicle.fee_for_day}</td>
        <td class="px-4 text-center">${vehicle.fee_for_1km}</td>
        <td class="px-4 text-center">${vehicle.driver_name}</td>
        <td class="px-4 text-center">${vehicle.drivel_contact}</td>
        <td class="px-4 text-center">${vehicle.remark}</td>
        
        <td><img src="data:guideImg/png;base64,${vehicle.side_img}" width="150"/></td>
        <td><img src="data:guideImg/png;base64,${vehicle.front_img}" width="150"/></td>
        <td><img src="data:guideImg/png;base64,${vehicle.back_img}" width="150"/></td>
        <td><img src="data:guideImg/png;base64,${vehicle.front_interior}" width="150"/></td>
        <td><img src="data:guideImg/png;base64,${vehicle.back_interior}" width="150"/></td>
        <td><img src="data:guideImg/png;base64,${vehicle.license_f_img}" width="150"/></td>
        <td><img src="data:guideImg/png;base64,${vehicle.license_b_img}" width="150"/></td>
        
        </tr>`;

        $("#tblVehicle").append(row);
      }
    },
    error: function (ob) {
      alert(ob.responseJSON.message);
    },
  });
}
