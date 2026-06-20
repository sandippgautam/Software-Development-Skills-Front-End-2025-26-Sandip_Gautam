// Hamburger menu
const hamburger = document.getElementById('hamburger');
const navLinks = document.getElementById('navLinks');

hamburger.addEventListener('click', function() {
  this.classList.toggle('open');
  navLinks.classList.toggle('show');
});

// Close nav when a link is clicked
navLinks.querySelectorAll('a').forEach(function(link) {
  link.addEventListener('click', function() {
    hamburger.classList.remove('open');
    navLinks.classList.remove('show');
  });
});

// Accordion FAQ
var accItems = document.querySelectorAll('.acc-item');

accItems.forEach(function(item) {
  var btn = item.querySelector('.acc-btn');
  var content = item.querySelector('.acc-content');

  btn.addEventListener('click', function() {
    var isOpen = item.classList.contains('open');

    // close all
    accItems.forEach(function(i) {
      i.classList.remove('open');
      i.querySelector('.acc-content').style.maxHeight = null;
    });

    if (!isOpen) {
      item.classList.add('open');
      content.style.maxHeight = content.scrollHeight + 'px';
    }
  });
});

// Slideshow
var slides = document.querySelectorAll('.slide');
var dotsContainer = document.getElementById('dots');
var current = 0;
var timer;

slides.forEach(function(_, i) {
  var dot = document.createElement('button');
  dot.className = 'dot' + (i === 0 ? ' active' : '');
  dot.addEventListener('click', function() { goTo(i); });
  dotsContainer.appendChild(dot);
});

function getDots() { return dotsContainer.querySelectorAll('.dot'); }

function goTo(index) {
  slides[current].classList.remove('active');
  getDots()[current].classList.remove('active');
  current = (index + slides.length) % slides.length;
  slides[current].classList.add('active');
  getDots()[current].classList.add('active');
}

document.getElementById('prevBtn').addEventListener('click', function() {
  clearInterval(timer);
  goTo(current - 1);
  startTimer();
});

document.getElementById('nextBtn').addEventListener('click', function() {
  clearInterval(timer);
  goTo(current + 1);
  startTimer();
});

function startTimer() {
  timer = setInterval(function() { goTo(current + 1); }, 4500);
}
startTimer();

// Contact form
function submitForm(e) {
  e.preventDefault();
  document.getElementById('formMsg').style.display = 'block';
  e.target.reset();
  setTimeout(function() {
    document.getElementById('formMsg').style.display = 'none';
  }, 4000);
}
