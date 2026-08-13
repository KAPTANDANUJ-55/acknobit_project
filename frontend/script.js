  document.addEventListener('DOMContentLoaded',()=> {
  const statsBar = document.querySelector(".stats-bar");
  const numbers = document.querySelectorAll(".stat .number");
const projectsElement = numbers[0]; 
    if (projectsElement) {
        const savedProjects = localStorage.getItem("projectsCount");
        if (savedProjects) {
            projectsElement.setAttribute("data-target", savedProjects);
        }
    }

  const startcounter = () => {
    numbers.forEach((num) =>{
      const target = parseInt(num.getAttribute("data-target"));
      const suffix = num.getAttribute("data-suffix") || ""; // this includes + - % whhich is added like 170+, .etc
      let curr=0;
      const duration= 1000;

      const increment= target/(duration/16);
      const updatecount = () =>{
        curr+=increment;

        if(curr<target){
          num.innerText = Math.ceil(curr) + suffix;
                      requestAnimationFrame(updatecount);
        }

        else{
          num.innerText = target+suffix
        }
      };

      updatecount();

    })
  }

  const observer = new IntersectionObserver(
          (entries) => {
              entries.forEach((entry) => {
                  if (entry.isIntersecting) {
                    
                      statsBar.classList.add("spin-active");
                    
                      startcounter();
                    
                      observer.unobserve(entry.target);
                  }
              });
          },
          { threshold: 0.4 }
  );

      if (statsBar) {
          observer.observe(statsBar);
      }


      const leadForm = document.getElementById("leadform");
      if(leadForm){
        leadForm.addEventListener("submit",(e)=>{
         e.preventDefault() ;
         if(projectsElement){
        let currentTarget = parseInt(projectsElement.getAttribute("data-target")) || 150;
        let newCount = currentTarget + 1;
        localStorage.setItem("projectsCount", newCount);
                projectsElement.setAttribute("data-target", newCount);
                
                const suffix = projectsElement.getAttribute("data-suffix") || "";
                projectsElement.innerText = newCount + suffix;
         }
       leadForm.reset();
        });
          
        }
      
  });