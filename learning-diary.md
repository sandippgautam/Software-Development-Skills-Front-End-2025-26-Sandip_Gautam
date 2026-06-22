**LUT University (School of Business and Management)**
**Software Development Skills — Front-End, Online course**
**Sandip Gautam**

---

# LEARNING DIARY — FRONT-END MODULE

---

**Date:** 16.6.2026

**Activity:** Read through the general course information page. Watched the course introduction video. Set up my development environment — installed VS Code and chose extensions (Prettier, Live Server, GitLens). Created the GitHub repository and made the first commit.

**Learning outcome:** I understood the overall goal of the module — to learn how to combine HTML, CSS, and JavaScript to create visual and interactive web page effects, and to build a real deployable project. I also refreshed my memory on Git workflow: init, add, commit, push. Setting up Live Server was new to me and I found it really useful because the browser updates automatically every time I save a file, which speeds up the work a lot.

---

**Date:** 17.6.2026

**Activity:** Watched the "Introduction and Base HTML" section [0:00–19:20] of the course video. Built the base HTML structure of my portfolio website — navbar, hero section, about section, and the start of the projects section.

**Learning outcome:** I learned about the importance of using proper semantic HTML5 elements like `<nav>`, `<section>`, `<footer>` instead of just `<div>` for everything. Semantic elements make the code easier to read and also help with accessibility. I also finally understood why we put `<meta name="viewport" content="width=device-width, initial-scale=1.0">` in the head — it tells the browser how to scale the page on mobile devices, which is essential for responsive design.

---

**Date:** 18.6.2026

**Activity:** Watched the "Links and Core CSS" section [19:20–31:00]. Created the main CSS stylesheet. Styled the navbar and hero section. Learned about CSS custom properties and how to structure a stylesheet properly.

**Learning outcome:** I learned how to use CSS custom properties (variables) with the `:root` selector. Instead of writing the same colour value in many places, I define it once as `--primary: #3a7bd5` and use it everywhere. This makes the whole stylesheet much easier to maintain. I also learned how `position: sticky` works for the navbar so it stays visible while scrolling. There was a bit of confusion at first around CSS specificity — some of my styles were not applying because they were being overridden — but after reading the MDN docs I understood the cascade better.

---

**Date:** 19.6.2026

**Activity:** Watched the "Buttons & Utility Classes" [31:00] and "CSS Grid & Cards" [56:00] sections. Created reusable button classes and built the projects section with CSS Grid layout.

**Learning outcome:** I learned how to create utility and reusable CSS classes like `.btn`, `.btn-outline`, `.btn-sm` so I don't have to restyle buttons from scratch each time. The most useful new thing today was CSS Grid — specifically `grid-template-columns: repeat(3, 1fr)`. The `1fr` unit means "one fraction of the available space", so three columns share the space equally. I also understood the difference between Grid and Flexbox better: Grid is for two-dimensional layouts (rows and columns at the same time), while Flexbox is better for one-dimensional layouts like a row of items or a column. I used both — Grid for the card layout and Flexbox inside each card to stack content vertically.

---

**Date:** 20.6.2026

**Activity:** Watched the "FAQ elements" section [1:12:20]. Built the interactive accordion FAQ component with JavaScript. Also built the image slideshow and added the footer section.

**Learning outcome:** This was the first time I added real JavaScript interactivity to the project. For the accordion I used `element.style.maxHeight = element.scrollHeight + 'px'` to animate the expand/collapse smoothly — if you use `display: none/block` there is no animation, but controlling `max-height` lets the CSS transition run. I also learned the `closest()` DOM method which finds the nearest matching ancestor element — cleaner than chaining `parentElement` multiple times. For the slideshow I used `setInterval` for auto-play and toggled an `.active` CSS class to control which slide is visible. Building the footer with CSS Grid for three columns was also good practice.

---

**Date:** 21.6.2026

**Activity:** Watched the "Mobile Menu & Responsiveness" section [1:47:05]. Added media queries for tablet and mobile breakpoints. Built the hamburger mobile menu with JavaScript toggle.

**Learning outcome:** This was the most challenging session but also the most satisfying when it all worked. I added `@media (max-width: 700px)` breakpoints to make the layout adapt to smaller screens — the three-column card grid collapses to a single column, the hero stacks vertically, and the navbar links hide and are replaced by a hamburger icon. The hamburger button works by toggling a `.show` class on the nav links list which changes its `display` property. The click logic was in JavaScript but the visual change is handled by CSS, which is the clean way to do it. I tested by resizing the browser window in Chrome and also checked in Firefox — it worked correctly in both.

---

**Date:** 22.6.2026

**Activity:** Watched "Website Deployment" [Part 7]. Deployed the website using GitHub Pages. Did a final review of all pages and sections. Completed README file with project documentation and added the video demo file.

**Learning outcome:** Deploying to GitHub Pages was straightforward — push the code to GitHub and enable Pages in the repository settings. The site went live within a couple of minutes at a public URL which felt great. During the final review I checked that all navbar links scroll to the correct sections, the mobile menu closes when a link is clicked, the accordion and slideshow work correctly, and the contact form shows a success message. I also wrote the README to explain the project and how to run it locally, which I learned is important for anyone else who might look at the repository. Overall this module gave me a solid understanding of how to plan and build a complete responsive front-end project from scratch.
