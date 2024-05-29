// Frontend and backend functions

var baseUrl = "http://localhost:8087/travelPlanning/guide";

loadAllGuide();

$("#btnSaveGuide").click(function () {
  saveGuide();
});

function saveGuide() {
  const formData = new FormData();

  const guideName = $("#guideName").val();
  const address = $("#address").val();
  const age = $("#age").val();
  const gender = $("#gender").val();
  const contact = $("#contact").val();
  const experience = $("#experience").val();
  const dayvalue = $("#dayvalue").val();
  const remark = $("#remark").val();
  const guideImg = $("#input-file1").val();
  const nicFImg = $("#input-file2").val();
  const nicBImg = $("#input-file3")[0].files[0];
  const guideIDFImg = $("#input-file4")[0].files[0];
  const guideIDBImg = $("#input-file5")[0].files[0];

  formData.append("guideName", guideName);
  formData.append("address", address);
  formData.append("age", age);
  formData.append("gender", gender);
  formData.append("contact", contact);
  formData.append("experience", experience);
  formData.append("man_day_value", dayvalue);
  formData.append("remark", remark);
  formData.append("guideImg", guideImg);
  formData.append("nicFImg", nicFImg);
  formData.append("nicBImg", nicBImg);
  formData.append("guideIDFImg", guideIDFImg);
  formData.append("guideIDBImg", guideIDBImg);

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

function loadAllGuide() {
  $("#tblGuide").empty();

  $.ajax({
    url: baseUrl,
    processData: false,
    contentType: false,
    cache: false,
    method: "GET",
    success: function (res) {
      for (const guide of res.data) {
        let row = `<tr>

        <td class="px-4 text-center">${guide.guideID}</td>
        <td class="px-4 text-center">${guide.guideName}</td>
        <td class="px-4 text-center">${guide.address}</td>
        <td class="px-4 text-center">${guide.age}</td>
        <td class="px-4 text-center">${guide.gender}</td>
        <td class="px-4 text-center">${guide.contact}</td>
        <td class="px-4 text-center">${guide.experience}</td>
        <td class="px-4 text-center">${guide.man_day_value}</td>
        <td class="px-4 text-center">${guide.remark}</td>
        
        <td><img src="data:guideImg/png;base64,${guide.guideImg}" width="100"/></td>
        <td><img src="data:guideImg/png;base64,${guide.nicFImg}" width="100"/></td>
        <td><img src="data:guideImg/png;base64,${guide.nicBImg}" width="100"/></td>
        <td><img src="data:guideImg/png;base64,${guide.guideIDFImg}" width="100"/></td>
        <td><img src="data:guideImg/png;base64,${guide.guideIDBImg}" width="100"/></td>
        
        </tr>`;

        $("#tblGuide").append(row);
      }
    },
    error: function (ob) {
      alert(ob.responseJSON.message);
    },
  });
}
