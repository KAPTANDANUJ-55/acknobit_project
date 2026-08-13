//   document.addEventListener('DOMContentLoaded',()=> {
//   const statsBar = document.querySelector(".stats-bar");
//   const numbers = document.querySelectorAll(".stat .number");
// const projectsElement = numbers[0]; 
//     if (projectsElement) {
//         const savedProjects = localStorage.getItem("projectsCount");
//         if (savedProjects) {
//             projectsElement.setAttribute("data-target", savedProjects);
//         }
//     }

//   const startcounter = () => {
//     numbers.forEach((num) =>{
//       const target = parseInt(num.getAttribute("data-target"));
//       const suffix = num.getAttribute("data-suffix") || ""; // this includes + - % whhich is added like 170+, .etc
//       let curr=0;
//       const duration= 1000;

//       const increment= target/(duration/16);
//       const updatecount = () =>{
//         curr+=increment;

//         if(curr<target){
//           num.innerText = Math.ceil(curr) + suffix;
//                       requestAnimationFrame(updatecount);
//         }

//         else{
//           num.innerText = target+suffix
//         }
//       };

//       updatecount();

//     })
//   }

//   const observer = new IntersectionObserver(
//           (entries) => {
//               entries.forEach((entry) => {
//                   if (entry.isIntersecting) {
                    
//                       statsBar.classList.add("spin-active");
                    
//                       startcounter();
                    
//                       observer.unobserve(entry.target);
//                   }
//               });
//           },
//           { threshold: 0.4 }
//   );

//       if (statsBar) {
//           observer.observe(statsBar);
//       }


//       const leadForm = document.getElementById("leadform");
//       if(leadForm){
//         leadForm.addEventListener("submit",(e)=>{
//          e.preventDefault() ;
//          if(projectsElement){
//         let currentTarget = parseInt(projectsElement.getAttribute("data-target")) || 150;
//         let newCount = currentTarget + 1;
//         localStorage.setItem("projectsCount", newCount);
//                 projectsElement.setAttribute("data-target", newCount);
                
//                 const suffix = projectsElement.getAttribute("data-suffix") || "";
//                 projectsElement.innerText = newCount + suffix;
//          }
//        leadForm.reset();
//         });
          
//         }
      
//         const chatbotContainer= document.getElementById("chatbot-container");
//         const closeBtn = document.getElementById("close-btn");
//         const sendBtn = document.getElementById("send-btn");
//         const chatbotInput = document.getElementById("chatbot-input");
//         const chatbotMessages = document.getElementById("chatbot-messages");

//         const chatbotIcon = document.getElementById("chatbot-icon");
//         const closeButton = document.getElementById("close-btn");

//          chatbotIcon.addEventListener("click", function () {
//           chatbotContainer.classList.remove("hidden");
//            chatbotIcon.style.display = "none";
//          });

//           closeButton.addEventListener("click", function () {
//     chatbotContainer.classList.add("hidden");
//     chatbotIcon.style.display = "flex";

//   })

//     sendBtn.addEventListener("click", sendMessage);
//   chatbotInput.addEventListener("keypress", function (e) {
//     if (e.key === "Enter") {
//       sendMessage();
//     }
//   });

//    function sendMessage() {
//     const userMessage = chatbotInput.value.trim();
//     if (userMessage) {
//       appendMessage("user", userMessage);
//       chatbotInput.value = "";
//       getBotResponse(userMessage);
//     }
//   }

//     function appendMessage(sender, message) {
//     const messageElement = document.createElement("div");
//     messageElement.classList.add("message", sender);
//     messageElement.textContent = message;
//     chatbotMessages.appendChild(messageElement);
//     chatbotMessages.scrollTop = chatbotMessages.scrollHeight;
//   }
//    function getBotResponse(userMessage){
//     const API_KEY = "AIzaSyBcVNXJuhyeBGzuIPeSJl-iE_TeikAde1E";
//     const API_URL = `https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=${AIzaSyBcVNXJuhyeBGzuIPeSJl-iE_TeikAde1E}`
//     const API_KEY = "YOUR_GEMINI_API_KEY";
// const URL = `https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=${API_KEY}`;

// fetch(URL, {
//   method: "POST",
//   headers: {
//     "Content-Type": "application/json"
//   },
//   body: JSON.stringify({
//     contents: [
//       {
//         parts: [{ text: "Greetings From Acknobit Team" }]
//       }
//     ]
//   })
// })


//    }
//   });



  

  document.addEventListener('DOMContentLoaded', () => {
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
        numbers.forEach((num) => {
            const target = parseInt(num.getAttribute("data-target"));
            const suffix = num.getAttribute("data-suffix") || "";
            let curr = 0;
            const duration = 1000;

            const increment = target / (duration / 16);
            const updatecount = () => {
                curr += increment;

                if (curr < target) {
                    num.innerText = Math.ceil(curr) + suffix;
                    requestAnimationFrame(updatecount);
                } else {
                    num.innerText = target + suffix;
                }
            };

            updatecount();
        });
    };

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

    const leadForm = document.getElementById("leadForm");
    if (leadForm) {
        leadForm.addEventListener("submit", (e) => {
            e.preventDefault();
            if (projectsElement) {
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

    const chatbotContainer = document.getElementById("chatbot-container");
    const closeBtn = document.getElementById("close-btn");
    const sendBtn = document.getElementById("send-btn");
    const chatbotInput = document.getElementById("chatbot-input");
    const chatbotMessages = document.getElementById("chatbot-messages");
    const chatbotIcon = document.getElementById("chatbot-icon");

    if (chatbotIcon && chatbotContainer) {
        chatbotIcon.addEventListener("click", function () {
            chatbotContainer.classList.remove("hidden");
            chatbotIcon.style.display = "none";
        });
    }

    if (closeBtn && chatbotContainer && chatbotIcon) {
        closeBtn.addEventListener("click", function () {
            chatbotContainer.classList.add("hidden");
            chatbotIcon.style.display = "flex";
        });
    }

    if (sendBtn && chatbotInput) {
        sendBtn.addEventListener("click", sendMessage);
        chatbotInput.addEventListener("keypress", function (e) {
            if (e.key === "Enter") {
                sendMessage();
            }
        });
    }

    function sendMessage() {
        const userMessage = chatbotInput.value.trim();
        if (userMessage) {
            appendMessage("user", userMessage);
            chatbotInput.value = "";
            getBotResponse(userMessage);
        }
    }

    function appendMessage(sender, message) {
        const messageElement = document.createElement("div");
        messageElement.classList.add("message", sender);
        messageElement.textContent = message;
        chatbotMessages.appendChild(messageElement);
        chatbotMessages.scrollTop = chatbotMessages.scrollHeight;
    }

});