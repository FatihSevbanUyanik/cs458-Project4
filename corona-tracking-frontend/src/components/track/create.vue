<template>
   <div class="px-5">
      <v-card class="mx-auto my-5 elevation-1" outlined max-width="1000">
         <v-row class="px-3" justify="center">
            <v-col class="font-weight-bold" align-self="center">Create Daily Track</v-col>
         </v-row>
         <v-divider></v-divider>
        
        <div class="pa-3">
            <div>
               Please enter the Symptoms you have today.
            </div>
            <v-divider class="mt-2"></v-divider>
            <v-switch class="mx-5" label="Fever" v-model="symptoms.fever"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Cough" v-model="symptoms.cough"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Tiredness" v-model="symptoms.tiredness"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Difficulty in Breathing" v-model="symptoms.difficultBreathing"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Muscle Aches" v-model="symptoms.muscleAche"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Chills" v-model="symptoms.chills"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Sore Throat" v-model="symptoms.soreThroat"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Runny Nose" v-model="symptoms.runnyNose"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Headache" v-model="symptoms.headAche"></v-switch>
            <v-divider></v-divider>
            <v-switch class="mx-5" label="Chest Pain" v-model="symptoms.chestPain"></v-switch>
            <v-divider></v-divider>
            <div class="text-center">
               <v-btn color="accent" @click="upload" class="mt-3">Upload</v-btn>
            </div>
        </div>
      </v-card>
   </div>
</template>

<script>
export default {
   data() {
      return {
         symptoms: {
            fever: false,
            cough: false,
            tiredness: false,
            difficultBreathing: false,
            muscleAche: false,
            chills: false,
            soreThroat: false,
            runnyNose: false,
            headAche: false,
            chestPain: false
         }
      }
   },
   methods: {
      upload() {
         this.$store.dispatch('createTrack', this.symptoms)
                    .then(result => { 
                       if (result.success) {
                          this.$toastr.s('Track successfully created.') 
                          this.$router.push({ name: 'track.index' })
                       } else {
                          this.$toastr.e('Track could not be created.') 
                       }
                     })
                    .catch(error => { console.log(error) })
      }
   }
};
</script>
