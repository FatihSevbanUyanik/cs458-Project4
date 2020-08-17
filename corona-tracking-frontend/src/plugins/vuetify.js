import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

const vuetify = new Vuetify({
   theme: {
     themes: {
       light: {
         primary: '#00796B',
         secondary: '#009688',
         accent: '#4CAF50',
         error: '#E64A19',
       }
     },
   },
})

export default vuetify
