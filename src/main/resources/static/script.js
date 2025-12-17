document.addEventListener("DOMContentLoaded", (e => {
    const vis_btn = document.getElementById("vis");
    vis_btn.addEventListener("click", visAlle);

    const vis_en = document.getElementById("vis-en");
    vis_en.addEventListener("click", visEn);
}))

// GET - alle
async function visAlle() {
    try {
        const response = await fetch("http://localhost:8080/persons", {
            method: "GET",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        if (!response.ok) {
            throw new Error('HTTP error! status: ${response.status}');
        }
        const result = await response.json();
        console.log(result);
        return result;
    } catch (error) {
        console.error("Fetch error: ", error);
        throw error;
    }
}

// GET - en
async function visEn() {
    try {
        const response = await fetch("http://localhost:8080/persons/2", {
            method: "GET",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        if (!response.ok) {
            throw new Error('HTTP error! status: ${response.status}');
        }
        const result = await response.json();
        console.log(result);
        return result;
    } catch (error) {
        console.error("Fetch error: ", error);
        throw error;
    }
}

// POST - opprett ny
async function opprett() {
    try {
        const response = await fetch ("http://localhost:8080/persons", {
            method: "POST",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        console.error("Fetch error: ", error);
        throw error;
    }
}