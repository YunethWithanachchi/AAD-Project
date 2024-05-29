// Frontend and backend functions

var baseUrlSave = "http://localhost:8085/travelPlanning/user/save";

var baseUrl = "http://localhost:8085/travelPlanning/user";

loadAllVehicle();

$("#btnSaveUser").click(function () {
  saveUser();
});

function saveUser() {
  const formData = new FormData();

  const UserName = $("#UserName").val();
  const address = $("#address").val();
  const email = $("#email").val();
  const nicNo = $("#nicNo").val();
  const phone = $("#phone").val();
  const gender = $("#gender").val();
  const age = $("#age").val();
  const remark = $("#remark").val();
  const password = $("#password").val();
  const profileIMG = $("#input-file1")[0].files[0];
  const nicFIMG = $("#input-file1")[0].files[0];
  const nicBIMG = $("#input-file1")[0].files[0];

  formData.append("userName", UserName);
  formData.append("address", address);
  formData.append("email", email);
  formData.append("nicNo", nicNo);
  formData.append("phone", phone);
  formData.append("gender", gender);
  formData.append("age", age);
  formData.append("remark", remark);
  formData.append("password", password);
  formData.append("profileImg", profileIMG);
  formData.append("nicFImg", nicFIMG);
  formData.append("nicBImg", nicBIMG);

  $.ajax({
    url: baseUrlSave,
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

function loadAllVehicle() {
  $("#tblUser").empty();

  $.ajax({
    url: baseUrl,
    processData: false,
    contentType: false,
    cache: false,
    method: "GET",
    success: function (res) {
      for (const user of res.data) {
        let row = `<tr>

        <td class="px-4 text-center">${user.userID}</td>
        <td class="px-4 text-center">${user.userName}</td>
        <td class="px-4 text-center">${user.address}</td>
        <td class="px-4 text-center">${user.email}</td>
        <td class="px-4 text-center">${user.nicNo}</td>
        <td class="px-4 text-center">${user.phone}</td>
        <td class="px-4 text-center">${user.gender}</td>
        <td class="px-4 text-center">${user.age}</td>
        <td class="px-4 text-center">${user.remark}</td>
        <td class="px-4 text-center">${user.password}</td>
        
        <td><img src="data:guideImg/png;base64,${user.profileImg}" width="100"/></td>
        <td><img src="data:guideImg/png;base64,${user.nicFImg}" width="100"/></td>
        <td><img src="data:guideImg/png;base64,${user.nicBImg}" width="100"/></td>
        
        </tr>`;

        $("#tblUser").append(row);
      }
    },
    error: function (ob) {
      alert(ob.responseJSON.message);
    },
  });
}
