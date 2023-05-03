const nameInput = document.getElementById("name-input")
const submitButton = document.getElementById("submit-button")
const greetingDiv = document.getElementById("greeting")
const nameSpan = document.getElementById("name")
const nameForm = document.getElementById("name-form")

submitButton.addEventListener("click", function () {
  const name = nameInput.value.trim()

  // check if name contains only letters
  if (/^[a-zA-Z]+$/.test(name)) {
    nameSpan.textContent = name
    nameInput.value = ""
    greetingDiv.style.display = "block"
    nameForm.style.display = "none"
  } else {
    nameInput.value = ""
    submitButton.style.background = "red"
  }
})

const aboutUsBtn = document.getElementById("about-us-btn")
const aboutUsBox = document.getElementById("about-us-box")

aboutUsBtn.addEventListener("click", function () {
  if (aboutUsBox.style.display === "none") {
    aboutUsBox.style.display = "block"
    aboutUsBtn.classList.add("active")
  } else {
    aboutUsBox.style.display = "none"
    aboutUsBtn.classList.remove("active")
  }
})

const contactUsBtn = document.getElementById("contact-info-btn")
const contactUsBox = document.getElementById("contact-info-box")

contactUsBtn.addEventListener("click", function () {
  if (contactUsBox.style.display === "none") {
    if (locationBox.style.display === "flex") {
      locationBox.style.display = "none"
      locationBtn.classList.remove("active")
    }
    contactUsBox.style.display = "flex"
    contactUsBtn.classList.add("active")
  } else {
    contactUsBox.style.display = "none"
    contactUsBtn.classList.remove("active")
  }
})

const locationBtn = document.getElementById("location-btn")
const locationBox = document.getElementById("location-box")

locationBtn.addEventListener("click", function () {
  if (locationBox.style.display === "none") {
    if (contactUsBox.style.display === "flex") {
      contactUsBox.style.display = "none"
      contactUsBtn.classList.remove("active")
    }
    locationBox.style.display = "flex"
    locationBtn.classList.add("active")
  } else {
    locationBox.style.display = "none"
    locationBtn.classList.remove("active")
  }
})

const darkModeToggle = document.getElementById("dark-mode-toggle")

darkModeToggle.addEventListener("click", () => {
  const html = document.querySelector("html")
  html.dataset.theme = html.dataset.theme === "light" ? "dark" : "light"
  document.body.classList.toggle("dark-mode")
  darkModeToggle.textContent =
    html.dataset.theme === "light"
      ? "Switch to dark mode"
      : "Switch to light mode"
})
