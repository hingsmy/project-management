// For a pie chart
const labels = [
    'January',
    'February',
    'March'
];
const data = {
    labels: labels,
    datasets: [{
        label: 'My First dataset',
        backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
        borderColor: 'rgb(255, 99, 132)',
        data: [5, 2, 20],
    }]
};

const config = {
    type: 'pie',
    data: data,
    options: {}
};

new Chart(
    document.getElementById('myPieChart'),
    config
);
