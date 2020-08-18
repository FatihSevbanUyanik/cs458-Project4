<template>
   <v-card>
      <v-card-title>Track Detail</v-card-title>
      <v-divider></v-divider>
      <div class="pa-5">
         <div :class="detail.fever ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Fever
            </div>
         </div>
         <v-divider></v-divider>


         <div :class="detail.cough ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Cough
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.tiredness ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Tiredness
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.difficultBreathing ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Difficulty in Breathing
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.muscleAche ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Muscle Aches
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.chills ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Chills
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.soreThroat ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Sore Throat
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.runnyNose ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Runny Nose
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.headAche ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Headache
            </div>
         </div>
         <v-divider></v-divider>

         <div :class="detail.chestPain ? 'present': 'non-present'">
            <div class="subtitle-2 font-weight-bold pa-2">
               Chest Pain
            </div>
         </div>
      </div>         
      
     </v-card>
</template>

<script>
export default {
   props: ['detail']
}
</script>

<style>
.present {
   background-color: rgba(247, 36, 36, 0.137);
}

.non-present {
   background-color: rgba(186, 253, 86, 0.137)
}
</style>