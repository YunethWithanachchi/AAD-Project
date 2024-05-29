// Frontend and backend functions

var baseUrl = "http://localhost:8086/travelPlanning/hotel";

loadAllHotel();

$("#btnSaveHotel").click(function () {
  saveHotel();
});

function saveHotel() {
  const formData = new FormData();

  const hotelName = $("#hotelName").val();
  const location = $("#location").val();
  const category = $("#category").val();
  const starRate = $("#starRate").val();
  const email = $("#email").val();
  const phone = $("#phone").val();
  const petAllowed = $("#petAllowed").val();
  const cancellation = $("#cancellation").val();
  const hotelFee = $("#hotelFee").val();
  const remark = $("#remark").val();
  const hotelIMG = $("#input-file1")[0].files[0];

  formData.append("hotelName", hotelName);
  formData.append("location", location);
  formData.append("category", category);
  formData.append("starRate", starRate);
  formData.append("email", email);
  formData.append("phone", phone);
  formData.append("petAllowed", petAllowed);
  formData.append("cancellation", cancellation);
  formData.append("hotelFee", hotelFee);
  formData.append("remark", remark);
  formData.append("hotelIMG", hotelIMG);

  $.ajax({
    url: baseUrl,
    processData: false,
    contentType: false,
    cache: false,
    method: "POST",
    data: formData,
    success: function (res) {
      if (res.code == 200) {
        loadAllVehicle();
        alert(res.message);
      }
    },
    error: function (ob) {
      alert(ob.responseJSON.message);
    },
  });
}

function loadAllHotel() {
  $("#tblHotel").empty();

  $.ajax({
    url: baseUrl,
    processData: false,
    contentType: false,
    cache: false,
    method: "GET",
    success: function (res) {
      for (const hotel of res.data) {
        let row = `<tr>

        <td class="px-4 text-center">${hotel.hotelID}</td>
        <td class="px-4 text-center">${hotel.hotelName}</td>
        <td class="px-4 text-center">${hotel.location}</td>
        <td class="px-4 text-center">${hotel.category}</td>
        <td class="px-4 text-center">${hotel.starRate}</td>
        <td class="px-4 text-center">${hotel.email}</td>
        <td class="px-4 text-center">${hotel.phone}</td>
        <td class="px-4 text-center">${hotel.is_pet_allowed}</td>
        <td class="px-4 text-center">${hotel.cancellation}</td>
        <td class="px-4 text-center">${hotel.hotel_fee}</td>
        <td class="px-4 text-center">${hotel.remark}</td>
        
        <td><img src="data:guideImg/png;base64,${hotel.hotelImg}" width="100"/></td>
        
        </tr>`;

        $("#tblHotel").append(row);
      }
    },
    error: function (ob) {
      alert(ob.responseJSON.message);
    },
  });
}
