
console.log("Community Event Portal Loaded");

function registerEvent() {

    document.getElementById("outputMsg").value =
        "Registration Successful!";

}

function validatePhone() {

    let phone =
        document.getElementById("phone").value;

    if (!/^\d{10}$/.test(phone)) {

        alert("Enter a valid 10 digit phone number");

    }

}

function showFee() {

    let event =
        document.getElementById("eventType").value;

    let fee = "";

    if (event == "Music") {
        fee = "Fee : ₹500";
    }
    else if (event == "Sports") {
        fee = "Fee : ₹300";
    }
    else if (event == "Food") {
        fee = "Fee : ₹200";
    }

    document.getElementById("fee").innerHTML = fee;

    localStorage.setItem(
        "preferredEvent",
        event
    );

}

function enlargeImage() {

    let img =
        document.getElementById("zoomImage");

    img.style.width = "400px";
    img.style.height = "300px";

}

function countCharacters() {

    let text =
        document.getElementById("feedback").value;

    document.getElementById("count").innerHTML =
        text.length;

}

function videoReady() {

    document.getElementById("videoMessage").innerHTML =
        "Video ready to play";

}

window.onbeforeunload = function () {

    let name =
        document.getElementById("name").value;

    if (name !== "") {

        return "You have unsaved changes.";

    }

};

window.onload = function () {

    alert("Page Fully Loaded");

    sessionStorage.setItem(
        "lastVisit",
        new Date()
    );

    let savedEvent =
        localStorage.getItem("preferredEvent");

    if (savedEvent) {

        document.getElementById("eventType").value =
            savedEvent;

        showFee();

    }

}

function clearPreferences() {

    localStorage.clear();

    sessionStorage.clear();

    alert("Preferences Cleared");

}

function findLocation() {

    if (navigator.geolocation) {

        navigator.geolocation.getCurrentPosition(
            showPosition,
            showError,
            {
                enableHighAccuracy: true,
                timeout: 5000,
                maximumAge: 0
            }
        );

    }
    else {

        alert("Geolocation is not supported by this browser.");

    }

}

function showPosition(position) {

    document.getElementById("location").innerHTML =

        "Latitude: " +
        position.coords.latitude +

        "<br>Longitude: " +
        position.coords.longitude;

}

function showError(error) {

    switch (error.code) {

        case error.PERMISSION_DENIED:
            alert("Location permission denied");
            break;

        case error.TIMEOUT:
            alert("Location request timed out");
            break;

        default:
            alert("Unable to retrieve location");
    }

}


// ====================================
// Requirement 1
// ====================================

console.log("Welcome to the Community Portal");

// ====================================
// Requirement 2
// ====================================

const eventName = "Music Festival";

const eventDate = "15 June 2026";

let seats = 50;

console.log(
    `Event: ${eventName}
    Date: ${eventDate}
    Seats: ${seats}`
);

seats--;

console.log(
    `Remaining Seats: ${seats}`
);

// ====================================
// Requirement 5
// Objects and Prototypes
// ====================================

class Event {

    constructor(
        name,
        category,
        seats,
        date
    ) {

        this.name = name;
        this.category = category;
        this.seats = seats;
        this.date = date;

    }

}

Event.prototype.checkAvailability =
    function () {

        return this.seats > 0;

    };

// ====================================
// Requirement 6
// Arrays
// ====================================

let events = [

    new Event(
        "Music Festival",
        "Music",
        20,
        "2026-12-20"
    ),

    new Event(
        "Sports Day",
        "Sports",
        10,
        "2026-10-10"
    ),

    new Event(
        "Workshop on Baking",
        "Workshop",
        5,
        "2026-09-15"
    )

];

events.push(

    new Event(
        "Dance Night",
        "Music",
        15,
        "2026-11-11"
    )

);

const musicEvents =
    events.filter(

        event =>
            event.category === "Music"

    );

console.log(
    "Music Events",
    musicEvents
);

const formattedEvents =
    events.map(

        event =>
            `Event: ${event.name}`

    );

console.log(
    formattedEvents
);

// ====================================
// Requirement 4
// Functions
// ====================================

function addEvent(event) {

    events.push(event);

}

function registerUser(eventName) {

    let event =

        events.find(

            e =>
                e.name === eventName

        );

    try {

        if (

            !event ||

            event.seats <= 0

        ) {

            throw new Error(
                "No Seats Available"
            );

        }

        event.seats--;
        trackRegistration();

        renderEvents();

        console.log(
            "Registration Successful"
        );

    }

    catch (error) {

        console.log(
            error.message
        );

    }

}

function filterEventsByCategory(
    category
) {

    return events.filter(

        event =>

            category === "All"

                ?

                true

                :

                event.category === category

    );

}

// ====================================
// Closure
// ====================================

function registrationTracker() {

    let total = 0;

    return function () {

        total++;

        console.log(
            `Total Registrations: ${total}`
        );

    };

}

const trackRegistration =
    registrationTracker();

// ====================================
// Requirement 5
// Object.entries
// ====================================

Object.entries(events[0]).forEach(

    ([key, value]) => {

        console.log(
            key,
            value
        );

    }

);

// ====================================
// Requirement 7
// DOM Manipulation
// ====================================

function renderEvents(
    eventList = events
) {

    let container =

        document.querySelector(
            "#eventContainer"
        );

    if (!container) return;

    container.innerHTML = "";

    eventList.forEach(

        event => {

            let card =
                document.createElement(
                    "div"
                );

            card.className =
                "eventCard";

            card.innerHTML = `

                <h3>
                    ${event.name}
                </h3>

                <p>
                    Category:
                    ${event.category}
                </p>

                <p>
                    Seats:
                    ${event.seats}
                </p>

                <button
                onclick="registerUser('${event.name}')">

                Register

                </button>

            `;

            container.appendChild(
                card
            );

        }

    );

}

// ====================================
// Requirement 8
// Event Handling
// ====================================

document.addEventListener(

    "DOMContentLoaded",

    () => {

        renderEvents();

        let filter =

            document.querySelector(
                "#categoryFilter"
            );

        if (filter) {

            filter.onchange = function () {

                renderEvents(

                    filterEventsByCategory(
                        this.value
                    )

                );

            };

        }

        let searchBox =

            document.querySelector(
                "#searchBox"
            );

        if (searchBox) {

            searchBox.addEventListener(

                "keydown",

                function () {

                    let keyword =

                        this.value
                            .toLowerCase();

                    let filtered =

                        events.filter(

                            event =>

                                event.name
                                    .toLowerCase()

                                    .includes(
                                        keyword
                                    )

                        );

                    renderEvents(
                        filtered
                    );

                }

            );

        }

    }

);

// ====================================
// Requirement 9
// Promises
// ====================================

fetch(
    "https://jsonplaceholder.typicode.com/posts"
)

    .then(

        response =>

            response.json()

    )

    .then(

        data => {

            console.log(
                "Fetched Events",
                data
            );

        }

    )

    .catch(

        error => {

            console.log(
                error
            );

        }

    );

// ====================================
// Async Await
// ====================================

async function loadEvents() {

    try {

        console.log(
            "Loading..."
        );

        let response =

            await fetch(

                "https://jsonplaceholder.typicode.com/posts"

            );

        let data =

            await response.json();

        console.log(
            data
        );

    }

    catch (error) {

        console.log(
            error
        );

    }

}

loadEvents();

// ====================================
// Requirement 10
// ES6 Features
// ====================================

function greetUser(
    name = "Guest"
) {

    console.log(
        `Hello ${name}`
    );

}

const [firstEvent] = events;

const {
    name,
    category
} = firstEvent;

console.log(
    name,
    category
);

const clonedEvents =
    [...events];

// ====================================
// Requirement 11
// Form Handling
// ====================================

const form =
    document.querySelector(
        "#eventForm"
    );

if (form) {

    form.addEventListener(

        "submit",

        function (event) {

            event.preventDefault();

            const name =

                form.elements[0].value;

            const email =

                form.elements[1].value;

            if (

                name === ""

                ||

                email === ""

            ) {

                alert(
                    "Fill all fields"
                );

                return;

            }

            console.log(
                name,
                email
            );

        }

    );

}

// ====================================
// Requirement 12
// AJAX POST
// ====================================

function sendRegistration() {

    setTimeout(

        () => {

            fetch(

                "https://jsonplaceholder.typicode.com/posts",

                {

                    method: "POST",

                    headers: {

                        "Content-Type":
                            "application/json"

                    },

                    body: JSON.stringify({

                        user:
                            "Aashish"

                    })

                }

            )

                .then(

                    response =>

                        response.json()

                )

                .then(

                    data => {

                        console.log(
                            "Success",
                            data
                        );

                    }

                )

                .catch(

                    error => {

                        console.log(
                            "Failed",
                            error
                        );

                    }

                );

        },

        2000

    );

}

sendRegistration();

// ====================================
// Requirement 13
// Debugging
// ====================================

console.log(
    "Form Submission Started"
);

// ====================================
// Requirement 14
// jQuery Example
// ====================================

/*

$('#registerBtn').click(function(){

    alert("Registered");

});

$('.eventCard').fadeIn();

$('.eventCard').fadeOut();

Benefit of React/Vue:

Reusable Components
Faster UI Updates
Better State Management

*/