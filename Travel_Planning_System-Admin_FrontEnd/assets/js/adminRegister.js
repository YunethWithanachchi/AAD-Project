// Image Upload and view

const imgDiv = document.querySelector(".profileIMG-wrapper");
const img = document.querySelector("#photo");
const file = document.querySelector("#adminIMG");
const uploadbtn = document.querySelector("#uploadbtn");

file.addEventListener("change", function () {
  const chosedfile = this.files[0];
  if (chosedfile) {
    const reader = new FileReader();

    reader.addEventListener("load", function () {
      img.setAttribute("src", reader.result);
    });
    reader.readAsDataURL(chosedfile);
  }
});

// Frontend and backend functions

var baseUrl = "http://localhost:8083/travelPlanning/admin/save";

$("#saveAdminBtn").click(function () {
  saveAdmin();
});

function saveAdmin() {
  const formData = new FormData();

  const name = $("#adminName").val();
  const email = $("#adminEmail").val();
  const password = $("#adminPassword").val();
  const image = $("#adminIMG")[0].files[0];

  formData.append("adminName", name);
  formData.append("adminEmail", email);
  formData.append("adminPassword", password);
  formData.append("adminIMG", image);

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
    error: function (res) {
      alert(res.message);
    },
  });
}
