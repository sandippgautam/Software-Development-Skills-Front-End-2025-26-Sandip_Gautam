# Learning Diary — Front-End Module
**Lappeenranta University of Technology (LUT)**
**School of Business and Management**
**Course: Software Development Skills — Front-End**
**Student: Sandip Gautam**

---

## Day 1 — June 16, 2025

**Activity:** Read the general course information page and watched the introduction video. Set up my development environment.

**Learning outcome:**
I went through the course introduction carefully and understood that the goal is to combine HTML, CSS, and JavaScript to create interactive web page effects. The course is structured around a video series where I follow along and build a real project step by step. I decided to build a personal portfolio website as my project, since it felt like the most meaningful and useful thing I could create.

I installed VS Code and set up a few extensions that I found useful — Prettier for formatting, Live Server to preview my work in the browser instantly, and GitLens to track changes visually. I also created the GitHub repository and made my first commit with just the README. Setting up Git felt straightforward since I had some experience from previous courses, but it was good to refresh the workflow: init, add, commit, push.

---

## Day 2 — June 17, 2025

**Activity:** Watched "Introduction and Base HTML" section [0:00–19:20]. Created the base HTML structure for the project.

**Learning outcome:**
Today I focused on building the semantic HTML skeleton for my portfolio page. I learned about the importance of using the correct HTML5 semantic elements like `<nav>`, `<section>`, `<footer>`, and `<main>` — not just `<div>` for everything. This helps with accessibility and also makes the code much easier to read and maintain.

I built out the navbar, hero section, about section, and started the projects section. I also understood the concept of responsive design at a high level — the idea that one website should work well on both a phone screen and a desktop monitor. The `<meta name="viewport">` tag was something I had written before without fully understanding why; now I know it tells the browser how to scale the page on different devices.

I ran into a small issue where my Live Server wasn't auto-refreshing after I saved a file, but I figured out it was a VS Code setting and fixed it quickly.

---

## Day 3 — June 18, 2025

**Activity:** Watched "Links and Core CSS" section [19:20–31:00]. Created the core CSS stylesheet and learned about variables and nesting.

**Learning outcome:**
This was probably my favourite session so far. I learned how to use CSS custom properties (variables) with the `:root` selector, which makes it very easy to maintain a consistent color theme across the whole site. Instead of hardcoding the same hex color value in thirty different places, I define `--primary: #6c63ff` once and use it everywhere. When I want to change the theme color later, I change it in one place.

I set up all the base styles — typography, reset rules, the color palette — and styled the navigation bar. I learned about `position: fixed` to keep the navbar visible while scrolling. I also used `backdrop-filter: blur()` to give it a frosted glass effect, which looks really modern.

The hardest part was understanding CSS specificity and why some of my styles were being overridden. After some trial and error and reading MDN, I understood the cascade better.

---

## Day 4 — June 19, 2025

**Activity:** Watched "Buttons & Utility Classes" [31:00] and "CSS Grid & Cards" [56:00]. Built card components and the CSS Grid layout.

**Learning outcome:**
Today I worked on two major things: buttons and the project cards grid. I created reusable button classes — `.btn`, `.btn-primary`, `.btn-outline`, and `.btn-sm` — so I don't have to restyle buttons from scratch every time I use them. Utility classes like `.mt-1`, `.container`, etc. save a lot of repetition.

The most interesting part was CSS Grid. I used `grid-template-columns: repeat(3, 1fr)` to create a three-column card layout. The `1fr` unit was new to me — it means "one fraction of available space", so all three columns share the space equally. I also learned that CSS Grid is best for two-dimensional layouts (rows AND columns), while Flexbox is better for one-dimensional layouts (just a row or just a column). I used Flexbox inside each card to stack its content vertically.

The cards also got hover effects using `transform: translateY(-6px)` which lifts them slightly when you mouse over, making the page feel alive and interactive.

---

## Day 5 — June 20, 2025

**Activity:** Watched "FAQ elements" section [1:12:20]. Built the FAQ accordion section with JavaScript and added the footer.

**Learning outcome:**
Today I introduced JavaScript into the project for the first time. I built an accordion FAQ component where clicking a question expands the answer. The key technique was using `element.style.maxHeight = element.scrollHeight + 'px'` to animate the open/close smoothly — if you just use `display: none / block` there is no animation, but controlling `max-height` lets CSS transitions kick in.

I also learned to use `closest()` to traverse the DOM efficiently — instead of navigating up multiple `parentElement` calls, I can write `btn.closest('.accordion-item')` to find the nearest ancestor matching that selector.

I also built the footer using CSS Grid with three columns: brand info, navigation links, and social icons. Building the footer actually taught me a lot about how to structure repeated content cleanly.

The slideshow was also started today — a simple image carousel using an array of slides, toggling an `.active` class, and using `setInterval` for auto-play every 4 seconds.

---

## Day 6 — June 21, 2025

**Activity:** Watched "Mobile Menu & Responsiveness" section [1:47:05]. Added media queries and the mobile hamburger menu.

**Learning outcome:**
This was the most challenging day so far, but also very satisfying once it all worked. I added `@media (max-width: 768px)` breakpoints to make the layout responsive. The main changes on mobile were: the three-column card grid becomes single column, the navbar links hide and are replaced by a hamburger button, and the hero section stacks vertically instead of side by side.

The hamburger menu was the trickiest part. The button toggles an `.open` class on the nav links list, which changes its `transform: translateY(-110%)` to `translateY(0)` — essentially sliding the menu down from above the screen. The animation is handled by CSS `transition`, and the JavaScript just adds/removes the class. I also added logic to close the menu when any link is clicked, which is important for single-page sites where clicking a link just scrolls down instead of loading a new page.

I tested on multiple screen widths by resizing the browser and it looked good across all of them. I also checked in Firefox and Chrome — no differences, which was reassuring.

---

## Day 7 — June 22, 2025

**Activity:** Deployed the website using GitHub Pages. Final review and cleanup.

**Learning outcome:**
The last step was deployment. I pushed all my code to GitHub and then enabled GitHub Pages from the repository settings by pointing it at the `main` branch. Within a couple of minutes the site was live at a public URL. It felt great to see the project actually accessible on the internet.

I also did a final code review pass — checking for any typos, making sure all sections had IDs matching the navbar links so smooth scrolling works correctly, and verifying the contact form shows a success message without actually trying to send anything (since there's no backend).

Overall this module was very educational. I learned how to plan and build a complete, deployable front-end project from scratch. The most valuable lessons were about CSS Grid vs Flexbox (when to use each), CSS variables for maintainability, and using JavaScript to manipulate the DOM for interactive elements like accordions and carousels. I feel much more confident building responsive websites now than I did at the start.

---

*Learning diary completed as part of LUT Software Development Skills — Front-End module, 2025–26.*
