// Image input element

// const dropArea = document.querySelector("#drop-area");
const inputFile1 = document.querySelector("#input-file1");
const imageView1 = document.querySelector("#img-view1");

const inputFile2 = document.querySelector("#input-file2");
const imageView2 = document.querySelector("#img-view2");

const inputFile3 = document.querySelector("#input-file3");
const imageView3 = document.querySelector("#img-view3");

const inputFile4 = document.querySelector("#input-file4");
const imageView4 = document.querySelector("#img-view4");

const inputFile5 = document.querySelector("#input-file5");
const imageView5 = document.querySelector("#img-view5");

const inputFile6 = document.querySelector("#input-file6");
const imageView6 = document.querySelector("#img-view6");

const inputFile7 = document.querySelector("#input-file7");
const imageView7 = document.querySelector("#img-view7");

inputFile1.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile1.files[0]);
  imageView1.style.backgroundImage = `url(${imgLink})`;
  imageView1.textContent = "";
  imageView1.style.border = 0;
});

inputFile2.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile2.files[0]);
  imageView2.style.backgroundImage = `url(${imgLink})`;
  imageView2.textContent = "";
  imageView2.style.border = 0;
});

inputFile3.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile3.files[0]);
  imageView3.style.backgroundImage = `url(${imgLink})`;
  imageView3.textContent = "";
  imageView3.style.border = 0;
});

inputFile4.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile4.files[0]);
  imageView4.style.backgroundImage = `url(${imgLink})`;
  imageView4.textContent = "";
  imageView4.style.border = 0;
});

inputFile5.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile5.files[0]);
  imageView5.style.backgroundImage = `url(${imgLink})`;
  imageView5.textContent = "";
  imageView5.style.border = 0;
});

inputFile6.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile6.files[0]);
  imageView6.style.backgroundImage = `url(${imgLink})`;
  imageView6.textContent = "";
  imageView6.style.border = 0;
});

inputFile7.addEventListener("change", function () {
  let imgLink = URL.createObjectURL(inputFile7.files[0]);
  imageView7.style.backgroundImage = `url(${imgLink})`;
  imageView7.textContent = "";
  imageView7.style.border = 0;
});
