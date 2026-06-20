// ── Navbar scroll shadow ─────────────────────────────────────────────────────
const navbar = document.querySelector('.navbar');
window.addEventListener('scroll', () => {
  navbar.classList.toggle('scrolled', window.scrollY > 40);
});

// ── Mobile hamburger menu ─────────────────────────────────────────────────────
const hamburger = document.getElementById('hamburger');
const navLinks  = document.getElementById('navLinks');

hamburger.addEventListener('click', () => {
  hamburger.classList.toggle('active');
  navLinks.classList.toggle('open');
});

// Close menu when a link is clicked
navLinks.querySelectorAll('a').forEach(link => {
  link.addEventListener('click', () => {
    hamburger.classList.remove('active');
    navLinks.classList.remove('open');
  });
});

// ── FAQ Accordion ─────────────────────────────────────────────────────────────
document.querySelectorAll('.accordion-btn').forEach(btn => {
  btn.addEventListener('click', () => {
    const item    = btn.closest('.accordion-item');
    const content = item.querySelector('.accordion-content');
    const isOpen  = item.classList.contains('active');

    // Close all
    document.querySelectorAll('.accordion-item').forEach(i => {
      i.classList.remove('active');
      i.querySelector('.accordion-content').style.maxHeight = null;
    });

    // Open clicked (unless it was already open)
    if (!isOpen) {
      item.classList.add('active');
      content.style.maxHeight = content.scrollHeight + 'px';
    }
  });
});

// ── Image Slideshow ───────────────────────────────────────────────────────────
const slides    = document.querySelectorAll('.slide');
const dotsWrap  = document.getElementById('slideDots');
let current     = 0;
let slideTimer;

// Build dots
slides.forEach((_, i) => {
  const dot = document.createElement('button');
  dot.classList.add('dot');
  dot.setAttribute('aria-label', `Go to slide ${i + 1}`);
  if (i === 0) dot.classList.add('active');
  dot.addEventListener('click', () => goTo(i));
  dotsWrap.appendChild(dot);
});

function getDots() { return dotsWrap.querySelectorAll('.dot'); }

function goTo(index) {
  slides[current].classList.remove('active');
  getDots()[current].classList.remove('active');
  current = (index + slides.length) % slides.length;
  slides[current].classList.add('active');
  getDots()[current].classList.add('active');
}

function nextSlide() { goTo(current + 1); }
function prevSlide() { goTo(current - 1); }

document.getElementById('nextSlide').addEventListener('click', () => {
  clearInterval(slideTimer);
  nextSlide();
  startTimer();
});

document.getElementById('prevSlide').addEventListener('click', () => {
  clearInterval(slideTimer);
  prevSlide();
  startTimer();
});

function startTimer() {
  slideTimer = setInterval(nextSlide, 4000);
}
startTimer();

// ── Contact form ──────────────────────────────────────────────────────────────
function handleSubmit(e) {
  e.preventDefault();
  const success = document.getElementById('formSuccess');
  success.style.display = 'block';
  e.target.reset();
  setTimeout(() => { success.style.display = 'none'; }, 4000);
}

// ── Smooth active nav highlight on scroll ────────────────────────────────────
const sections = document.querySelectorAll('section[id]');
window.addEventListener('scroll', () => {
  const scrollY = window.scrollY + 100;
  sections.forEach(section => {
    const link = document.querySelector(`.nav-links a[href="#${section.id}"]`);
    if (!link) return;
    if (scrollY >= section.offsetTop && scrollY < section.offsetTop + section.offsetHeight) {
      document.querySelectorAll('.nav-links a').forEach(a => a.style.color = '');
      link.style.color = 'var(--primary)';
    }
  });
});
