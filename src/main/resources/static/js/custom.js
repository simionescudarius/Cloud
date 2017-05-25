$(function () {

    function initMap() {

        var isClear = true;
        var onlyOnce = false;
        var index = 0;
        var noisePollution = document.getElementById('cmn-toggle-3');
        var circleArray = [];
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: {lat: 37.090, lng: -95.712},
          mapTypeId: 'terrain'
        });

         google.maps.event.addDomListener(noisePollution, 'click', function() {
      if (Boolean(isClear) == true) {
              isClear = false;
              var citymap = {
              chicago: {
                center: {lat: 41.878, lng: -87.629},
                population: 2714856
              },
              newyork: {
                center: {lat: 40.714, lng: -74.005},
                population: 8405837
              },
              losangeles: {
                center: {lat: 34.052, lng: -118.243},
                population: 3857799
              },
              vancouver: {
                center: {lat: 49.25, lng: -123.1},
                population: 603502
              }
            };

             for (var city in citymap) {
              var cityCircle = new google.maps.Circle({
              strokeColor: '#FF0000',
              strokeOpacity: 0.8,
              strokeWeight: 2,
              fillColor: '#FF0000',
              fillOpacity: 0.35,
              map: map,
              center: citymap[city].center,
              radius: Math.sqrt(citymap[city].population) * 100
            });

            circleArray[index] = cityCircle;
            index++;
          }
        }else{
          isClear = true;
            for (var i = 0; i < index; i++){
              var c = new google.maps.Circle();
              console.log(c);
              c = circleArray[i];
              console.log(c);
              c.setMap(null);
            }
        }
    });
  }


    google.maps.event.addDomListener(window, 'load', initMap);
});


$(document).ready(function(e){
    $('.search-panel .dropdown-menu').find('a').click(function(e) {
        e.preventDefault();
        var param = $(this).attr("href").replace("#","");
        var concept = $(this).text();
        $('.search-panel span#search_concept').text(concept);
        $('.input-group #search_param').val(param);
    });
});

function loginModal(){
    $("#loginModal").modal();
}

function registerModal(){
    $("#registerModal").modal();
}

function declineModal(){
    $("#declineModal").modal();
}

function userModal(){
        $("#profileModal").modal();
}