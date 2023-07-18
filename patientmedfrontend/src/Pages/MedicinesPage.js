import React from 'react';
import { Typography, AppBar, Card, CardActions, CardContent, CardMedia, CssBaseline, Grid, Toolbar, Container } from '@material-ui/core';
import MedicationIcon from '@mui/icons-material/Medication';
import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';

function MedicinesPage() {
  return (
    <>
      <CssBaseline />  {/* Provides default styling */}
      <AppBar position='relative'>
        <Toolbar>
          <MedicationIcon /> {/* Icon in corner */}
          <Typography variant='h6'>
            My Medication {/* Text next to the icon*/}
          </Typography>
          <ButtonGroup variant="contained" aria-label="outlined primary button group">
            <Button>Home</Button>
            <Button></Button>
            <Button></Button>
            <Button></Button>
            <Button></Button>
            <Button></Button>
            <Button>Login</Button>
          </ButtonGroup>
        </Toolbar>
      </AppBar>
      <main>
        <div>
          <Container maxWidth='sm'> {/* Contains things within a specific area of the page */}
            <Typography variant='h2' align='center' color='textPrimary' gutterBottom> {/* Heading */}
              My Medication
            </Typography>
            <Typography variant='h5' align='center' color='texSecondary' paragraph> {/* Paragraph under header */}
              Here you can find all of your medicines and access information about them.
              Click on a medicine for additional information.
            </Typography>
            <div>
              <Grid container spacing={2} justifyContent='center'> {/* Grid's always come in pairs. Gridd container --> Wraps Grid item */}
                <Grid item>
                  <Button variant='contained' color='primary'>
                    See My Medication

                  </Button>
                </Grid>
              
              <Grid item>
                <Button variant='contained' color='primary'>
                  Seccond Action 

                </Button>
              </Grid>
              </Grid>
            </div>
          </Container>
        </div>

      </main>

    </>
  );
}

export default MedicinesPage;