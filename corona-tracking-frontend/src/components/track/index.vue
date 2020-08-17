<template>
   <div>
      <v-card class="mx-auto my-5 elevation-1" outlined max-width="1000">
         <div class="pa-3 font-weight-bold">Daily Trends</div>
         <v-divider></v-divider>
         <div class="pa-3">
            <v-card class="border-yellow" outlined>
               <v-row class="px-5">
                  <v-col class="col-4">
                     <div class="caption font-weight-medium grey--text">Date</div>
                     <div class="text-subtitle-2">09.08.2019</div>
                  </v-col>
                  <v-col class="col-3">
                     <div class="caption font-weight-medium grey--text">Symptomps</div>
                     <div class="text-subtitle-2">3 Symptomps</div>
                  </v-col>
                  <v-col class="col-3">
                     <div class="caption font-weight-medium grey--text">Status</div>
                     <div class="text-subtitle-2">Healthy</div>
                  </v-col>
                  <v-col class="col-2">
                     <v-btn color="secondary" class="elevation-1 mx-1" fab x-small dark>
                        <v-icon>mdi-television</v-icon>
                     </v-btn>
                     <v-btn color="red" class="elevation-1" fab x-small dark>
                        <v-icon>mdi-delete</v-icon>
                     </v-btn>
                  </v-col>
               </v-row>
            </v-card>

            
         </div>
      </v-card>
   </div>
</template>

<script>
export default {};
</script>

<style scoped>
.border-green {
   border-right: 5px solid green; 
   border-color:green
}

.border-yellow {
   border-right: 5px solid yellow; 
   border-color:yellow
}

.border-red {
   border-right: 5px solid red; 
   border-color:red
}
</style>