let chartDataStr = decodeHtml(chartData);
let chartJsonArray = JSON.parse(chartDataStr);

let arrayLength = chartJsonArray.length;

let numericData = [];
let labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
const data = {
    labels: labelData,
    datasets: [{
        label: 'My First dataset',
        backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
        data: numericData,
    }]
};

const config = {
    type: 'pie',
    data: data,
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
};

new Chart(
    document.getElementById('myPieChart'),
    config
);

// "[{"value": 1, "label": "COMPLETED"}, {"value": 2, "label": "INPROGRESS"}, {"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html) {
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}
