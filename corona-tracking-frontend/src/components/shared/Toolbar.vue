<template>
   <div>
      <nav>
         <v-toolbar dense class="darken-2 primary elevation-5">
            <div class="white--text font-weight-light">
               <v-icon color="white">mdi-blur-radial</v-icon>
               Corona 
               <span class="font-weight-bold">Tracker</span>
            </div>
            <v-spacer></v-spacer>
            <router-link
               v-if="isUserSignedIn"
               active-class="active"
               exact
               :to="{name: 'auth.signIn'}"
            >
               <v-btn class="primary darken-2 elevation-0 white--text" @click="signOut">
                  Sign Out
                  <v-icon class="ml-2">mdi-login-variant</v-icon>
               </v-btn>
            </router-link>
         </v-toolbar>
      </nav>
   </div>
</template>

<style scoped>
a {
   text-decoration: none;
}
</style>

<script>
import { mapGetters, mapMutations } from "vuex";

export default {
   computed: { ...mapGetters(["isUserSignedIn"]) },
   methods: { ...mapMutations(["signOut"]) }
};
</script>