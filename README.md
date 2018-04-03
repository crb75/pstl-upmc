# Affichage d'une graphe de dépendance d'un programme Java en utilisant la bibliothèque Piccolo2D.

## Guide pour les développeurs

Si vous êtes développeur de ce répo, <strong>après avoir cloné le répo</strong> veuillez suivre les instructions qui vous convient parmi les  suivantes:

<details>
  <summary>
    Si vous utilisez une version de git <samp>≥ 2.9</samp> <em>(Vous pouvez le voir par la commande <code>git --version</code>)</em>.<br/> <strong>Veuillez exécuter l'une des deux commandes suivantes</strong>:
  </summary>
  <ul>
    <li>
      <code> make init </code> <strong>(Pour les utilisateurs des systèmes Unix)</strong>
    </li>
    <li>
      <code>git config core.hooksPath .githooks</code> <strong>(Pour tous les systèmes d'exploitations)</strong>
    </li>
  </ul>
</details>
<details>
  <summary>
    Si vous utilisez une version de git <samp>< 2.9</samp> <em>(Vous pouvez le voir par la commande <code>git --version</code>)</em>. <br/><strong>Veuillez exécuter la commande suivante</strong>:
  </summary>
  <ul>
    <li>
      <code> find .git/hooks -type l -exec rm {} \;
            find .githooks -type f -exec ln -sf ../../{} .git/hooks/ \; 
      </code>
    </li>
  </ul>
</details>
<br/>
<em><strong>L'exécution de la commande choisie</strong> permettra de changer le PATH (le chemin d'accès) des hooks de <samp>git</samp> sur votre machine locale avec le dossier <samp>.githooks</samp>. <br/>
Ce changement permettra de mettre à jour de la dernière version du fichier <samp>puck2.jar</samp> à chaque fois que vous faites un <samp>push</samp> sur ce répo.</em>

## Guide d'importation

### Sur <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Feclipse.svg?alt=media&token=c1a40189-1236-407b-9568-52c292e46e3d" alt="Eclipse Logo" width="32" height="32" align="top"/> Eclipse

<details>
  <summary>En utilisant <strong>l'intégration git</strong></summary>
    <ol>
      <li>
        Cliquez sur <strong><samp>Import</samp></strong> dans l'onglet <strong><samp>File</samp></strong> de barre latérale d'Eclipse
        <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FimportEclipse1.png?alt=media&token=b90453a4-4b76-4bb6-ad43-ff9bf944c542" alt="Cliquez sur Import dans l'onglet File de barre latérale d'Eclipse"/>
       </li>
       <li>
        Sur la fenêtre qui s'ouvre choisissez <strong><samp>Projects from Git</samp></strong> qui se trouve sous la section Git. Cliquez sur le bouton <strong><samp>Next</samp></strong>.
        <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_2.png?alt=media&token=1d415087-e728-49d5-9d92-ccb6339ecfc8" alt="Sur la fenêtre qui s'ouvre choisissez Projects from FGit qui se trouve sous la section Git"/>
      </li>
      <li>
        Choisissez <strong><samp>Clone URI</samp></strong>. Cliquez sur le bouton <strong><samp>Next</samp></strong>.
        <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_3.png?alt=media&token=277631cb-72a9-4029-9f01-e54928904811" alt="Choisissez Clone URI"/>
      </li>
      <li>
        Entrez l'URL du répo qui est <code>https://github.com/Misteryagci/pstl-upmc.git</code> dans le champs de text libellé URI. <em>Une fois c'est fait, si tout se passe bien comme il faut vous allez voir que tous les champs vont se compléter automatiquement</em>. En suite cliquez sur le bouton <strong><samp>Next</samp></strong>.
        <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_4.png?alt=media&token=b3664687-d640-40bd-a8de-2518ee420b9d" alt="Entrez l'URL du répo qui est https://github.com/Misteryagci/pstl-upmc.git dans le champs de text libellé URI"/>
      </li>
      <li>
      La branche la plus récente est la branche <samp>master</samp>, donc vous pouvez <strong>décocher</strong> dans le menu déroulant la branche <strong><code>xml-reader</code></strong>. Cliquez sur le bouton <strong><samp>Next</samp></strong>.
      <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_5.png?alt=media&token=4fa8c594-b1eb-4940-a8d8-77077b5a4247" alt="La branche la plus récente est la branche master, donc vous pouvez décocher dans le menu déroulant la branche xml-reader"/>
      </li>
      <li>
       <strong>Vérifiez</strong> si tout est bien configuré. Si c'est le cas cliquez sur le bouton <strong><samp>Next</samp></strong>.
       <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_6.png?alt=media&token=275cb309-321f-4efb-9cdf-27d4dd763bd0" alt="Vérifiez si tout est bien configuré."/>
     </li>
     <li>
     Sélectionnez <strong><samp>Import as general project</samp></strong> et cliquez sur le bouton <strong><samp>Next</samp></strong>.
     <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_7.png?alt=media&token=e664baed-08b4-4789-8604-50ed806705d6" alt="Sélectionnez import as general project"/>
     </li>
     <li>
     <strong>Renommez</strong> le projet sous Eclipse comme vous désirez <strong>ou laissez le comme tel</strong> et cliquez sur <strong><samp>Finish</samp></strong>
     <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse_8.png?alt=media&token=776700e6-2d11-4541-9c68-fee7d0bb6ca1" alt="Renommez le projet comme vous désirez ou laissez le comme tel"/>
     </li>
     <li>
     Happy coding 😊
     </li>
    </ol>
</details>

<details>
  <summary><strong>En clonant le répo</strong> par vous même</summary>
  <ol>
  <li>
  Clonez le répo par en tapant la commande suivante dans une <strong>Terminal</strong><br/>
  <code>git clone https://github.com/Misteryagci/pstl-upmc.git</code>
  </li>
  <li>
  Cliquez sur <strong><samp>Import</samp></strong> dans l'onglet <strong><samp>File</samp></strong> de barre latérale d'Eclipse.
  <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FimportEclipse1.png?alt=media&token=b90453a4-4b76-4bb6-ad43-ff9bf944c542" alt=""/>
  </li>
  <li>
  Sur la fenêtre qui s'ouvre choisissez <strong><samp>Projects from Folder or Archive</samp></strong> qui se trouve sous la section <samp>General</samp>. Cliquez sur le bouton <strong><samp>Next</samp></strong>.
  <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse2.png?alt=media&token=45b4f9d9-5afe-4893-8cba-6c6f619d8456" alt="Sur la fenêtre qui s'ouvre choisissez Projects from Folder or Archive qui se trouve sous la section General">
  </li>
  <li>
  Depuis l'explorateur de fichiers <strong>trouvez le dossier que vous venez de cloner</strong> et cliquez sur le bouton <strong><samp>Open</samp></strong>.
  <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse3.png?alt=media&token=5e0f2b18-c3ee-448c-a246-2b54967088fd" alt="Depuis l'explorateur de fichiers trouvez le dossier que vous venez de cloner et cliquez sur Open">
  </li>
  <li>
  Pour compléter l'importation cliquez sur le bouton <strong><samp>Finish</samp></strong>
  <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FImportEclipse4.png?alt=media&token=f79121d0-b179-413e-85b1-bb5f4fc23de5" alt="Pour compléter l'importation cliquez sur le bouton Finish">
  </li>
  <li>
  Happy coding 😊
  </li>
  </ol>
</details>

<details>
  <summary>Importez comme un pro 😎</summary>
  <ol>
    <li>
      Dans un Terminal dirigez vous à votre workspace d'Eclipse. <em>Vous pouvez trouver le path exacte au démarrage de votre Eclipse.</em> <br/>
      <code>
      cd ~/Documents/workspace
      </code>
      <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FeclipsePro1.png?alt=media&token=23600c56-737c-42a9-a95c-b9f49e0373c9" alt="Vous pouvez trouver le chemin complet de votre workspace Eclipse au démarrage">
    </li>
    <li>
      Clonez le répo git en tapant la commande sur le même terminal dans le répertoire de votre workspace Eclipse <br/>
      <code>
      git clone git clone https://github.com/Misteryagci/pstl-upmc.git
      </code>
    </li>
    <li>
      Cliquez sur <strong><samp>Java Project</samp></strong> dans la section <strong><samp>New</samp></strong> dans l'onglet <strong><samp>File</samp></strong> de barre latérale d'Eclipse.
      <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FeclipsePro2.png?alt=media&token=0f411ace-6872-4871-b595-1b30bda6440e" alt="Cliquez sur Java Project dans la section New dans l'onglet File de barre latérale d'Eclipse">
    </li>
    <li>
      Entrez le nom du dossier que vous avez sélectionné quand vous avez cloné le répo.<em>Si vous n'avez pas entré d'autre paramètre que l'url de répo à la commande <code>git clone</code> par défaut c'est <samp>pstl-upmc</samp></em>. Et cliquez sur le bouton <strong><samp>Finish</samp></strong>.
      <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FeclipsePro3.png?alt=media&token=1a753972-c41d-4e8d-bd07-f4ae8eb6809f" alt="Entrez le nom du dossier que avez sélectionné quand vous avez cloné le répo.">
    </li>
    <li>
    Happy coding 😊
    </li>
  </ol>
</details>

### Sur <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJ_IDEA_Logo.svg?alt=media&token=4f8c266b-4d1c-4fa5-972a-19dbb23ad1be" alt="Eclipse Logo" width="32" height="32" align="top"/> IntelliJ

<details>
  <summary>En utilisant <strong>l'intégration git</strong></summary>
  <ol>
    <li>
    Au démarrage d'IntelliJ sur la fenêtre qui s'ouvre cliquez sur la section <strong><samp>Check out from Version Control</samp></strong>. Puis sur le menu déroulant cliquez sur la section <strong><samp>Github</samp></strong>.
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Fintellij0.png?alt=media&token=26ba41a6-2911-4131-be07-702b3123b8c1" alt="Au démarrage d'IntelliJ, sur la fenêtre qui s'ouvre cliquez sur la section Check out from Version Control. Puis sur le menu déroulant cliquez sur la section Github"/>
    </li>
    <li>
    Sur le champs de texte libellé <strong><samp>Git Repository URL</samp></strong>, entrez l'URL du répo de projet qui est <kbd>https://github.com/Misteryagci/pstl-upmc.git</kbd>. Puis appuyez sur le bouton <strong><samp>Clone</samp></strong>.
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJ1.png?alt=media&token=03972eca-d91b-4158-b3d4-a13a8a4a962a" alt="Sur le champs de texte libellé Git Repository URL, entre l'URL du répo de projet qui est https://github.com/Misteryagci/pstl-upmc.git. Puis appuyez sur le bouton Clone">
    </li>
    <li>
    Appuyez sur bouton <strong><samp>Yes</samp></strong> sur la boîte de dialogue qui vous demande d'ouvrir le projet IntelliJ que vous venez de cloner.<br/>
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJImportFromGitOpen.png?alt=media&token=0d64ddc7-965e-45b1-ba5a-284d6bd1c7f3" alt="Appuyez sur le bouton Yes sur la boîte de dialogue qui vous demande de créer un projet d'IntelliJ en partant les sources clonées.">
    </li>
    <li>
    Happy coding 😊
    </li>
  </ol>
</details>

<details>
  <summary><strong>En clonant le répo</strong> par vous même</summary>
  <ol>
    <li>
    Clonez le répo en tapant la commande suivante sur un <strong>Terminal</strong><br/>
    <code>git clone https://github.com/Misteryagci/pstl-upmc.git</code>
    </li>
    <li>
    Au démarrage d'IntelliJ sur la fenêtre qui s'ouvre cliquez sur la section <strong><samp>Open</samp></strong>.
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJImportWithOpen.png?alt=media&token=a8963326-157d-4ec4-829a-36928de29141" alt="Au démarrage d'IntelliJ, sur la fenêtre qui s'ouvre cliquez sur la section Open"/>
    </li>
    <li>
    Depuis <strong>l'explorateur des fichier</strong> qui s'ouvre <strong>trouvez le dossier que vous venez de cloner</strong> et puis cliquez sur le bouton <strong><samp>Open</samp></strong>.
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Fintellij11.png?alt=media&token=9f41c345-78cc-492c-a8e9-86c583e0a279" alt="Depuis l'explorateur des fichiers qui s'ouvre trouvez le dossier que vous venez de cloner et puis cliquez sur le bouton Open">
    </li>
    <li>
    Happy coding 😊
    </li>
  </ol>
</details>

## Guide d'exécution 


### Uniquement la partie de graphe de dépendance

<details>
  <summary> Sous <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Feclipse.svg?alt=media&token=c1a40189-1236-407b-9568-52c292e46e3d" alt="Eclipse Logo" width="32" height="32" align="top"/> Eclipse </summary>


  <ul>
    <li>
      <details>
        <summary>
          En exécutant <strong>manuellement le fichier <samp>NewDisplayDG</samp></strong> (<em>Risque de ne pas marcher si vous avez importé le projet en utilisant l'intégration <samp>git</samp></em>)
        </summary>
        <ol>
          <li>
            Faites <strong>un clique droit sur le dossier principal</strong> contenant le projet. Puis dans le menu déroulant cliquez sur <strong><samp>Java Application</samp></strong> sous la section <strong><samp>Run As</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FrunEclipse1.png?alt=media&token=e121056e-c502-4f98-a91b-1eb40e988cfe" alt="Faites un clique droit sur le dossier principal contenant le projet. Puis dans le menu déroulant cliquez sur Java Application sous la section Run As">
          </li>
          <li>
            Sur la fenêtre intitulée <samp>Select Java Application</samp> <strong>sélectionnez <samp>NewDisplayDG - com.puck.display.piccolo2d</samp></strong>. Puis cliquez sur le bouton <strong><samp>OK</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FrunEclipse2.png?alt=media&token=cda8fc2f-e2ba-477b-b35c-cc122e72cb65" alt="Sur la fenêtre intitulée Select Java Application sélectionnez NewDisplayDG - com.puck.display.piccolo2d. Puis cliquez sur le bouton OK.">
          </li>
        </ol>
      </details>
    </li>
    <li>
      <details>
        <summary>
          En utilisant le fichier <strong><samp>build.xml</samp></strong>
        </summary>
        <ol>
          <li>
            Faites <strong>un clique droit sur le fichier <samp>build.xml</samp></strong> dans le répertoire principal de projet. Puis dans le menu déroulant cliquez sur <strong><samp>2 Ant Build...</samp></strong> sous la section <strong><samp>Run As</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FbuildXMLEclipse0.png?alt=media&token=f61f27e5-c1d5-48b4-88bc-ea0cfd37bdb2" alt="Faites un clique droit sur le dossier principal contenant le projet. Puis dans le menu déroulant cliquez sur 2 Ant Build... sous la section Run As">
          </li>
          <li>
            Sur la fenêtre intitulée <samp>Edit Configuration</samp> <strong>chochez les cases <samp>build [default]</samp> et <samp>base</samp></strong>. Vérifiez bien que l'ordre dans la section <samp>Target execution order:</samp> est <samp>build, base</samp>. Puis cliquez sur le bouton <strong><samp>Run</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FbuildXMLEclipse2.png?alt=media&token=472bc48f-2d3a-4756-bbe1-3fd93a48312d" alt="Sur la fenêtre intitulée Edit Configuration cochez les cases build [default] et base. Vérifiez bien que l'ordre dans la section Target execution order est build, base. Puis cliquez sur le bouton Run">
          </li>
        </ol>
      </details>
    </li>
  </ul>
</details>

<details>
  <summary> Sous <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJ_IDEA_Logo.svg?alt=media&token=4f8c266b-4d1c-4fa5-972a-19dbb23ad1be" alt="Eclipse Logo" width="32" height="32" align="top"/> IntelliJ </summary>
  <ol>
    <li>
      <details>
        <summary>
          En exécutant <strong>manuellement le fichier <samp>NewDisplayDG</samp></strong>
        </summary>
          <ol>
            <li>
              Chargez le projet <strong>en sélectionnant le projet</strong> sur la fenêtre de démarrage.<br/>
              <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FrunIntelliJ1.png?alt=media&token=fc23661d-95d6-4d9d-b3f4-e90e7bc0bb6a" alt="Chargez le projet en sélectionnant le projet sur la fenêtre de démarrage">
            </li>
            <li>
              Trouvez le fichier <strong><samp>NewDisplayDG</samp></strong> qui se trouve dans le dossier <samp>display.piccolo2d</samp> qui se trouve dans le dossier <samp>com.puck</samp> qui se trouve dans le dossier <samp>src</samp> qui se trouve dans le dossier principal du projet. <strong>Faites un clique droit sur ce fichier</strong> et dans le menu déroulant <strong>cliquez sur <samp>Run 'NewDisplayDG.main()'</samp></strong>.<br/>
              <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FrunIntelliJ2.png?alt=media&token=2a0c94a8-a8a0-44f9-a616-215ac2b6cdbf" alt="Trouvez le fichier NewDisplayDG qui se trouve dans le dossier display.piccolo2d qui se trouve dans le dossier com.puck qui se trouve dans le dossier src qui se trouve dans le dossier principal du projet. Faites un clique droit sur ce fichier et dans le menu déroulant cliquez sur Run 'NewDisplayDG.main()'">
            </li>
          </ol>
      </details>
    </li>
    <li>
      <details>
        <summary>
          En utilisant <samp>Ant Build</samp>
        </summary>
        <ol>
          <li>
             Chargez le projet <strong>en sélectionnant le projet</strong> sur la fenêtre de démarrage.<br/>
              <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJOpenForAntbuild.png?alt=media&token=bdd1f3e9-50fb-4b60-8563-176237fbebca" alt="Chargez le projet en sélectionnant le projet sur la fenêtre de démarrage">
          </li>
          <li>
              Dans la partie intitulé <samp>Ant Build</samp> qui se trouve à droite de la fenêtre <samp>d'IntelliJ</samp>, cliquez deux fois sur la cible <strong><samp>Build</samp></strong>. <em>( Contrairement à Eclipse IntelliJ ne build pas les projets automatiquement, donc il faut le faire manuellement.)</em> <br/>
              <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJAntBuild.png?alt=media&token=c10bfb8c-52ec-4973-9133-bc644ae08854" alt="Dans la partie intitulé Ant Build qui se trouve à droite de la fenêtre d'IntelliJ cliquez deux fois sur la cible Build."/>
          </li>
          <li>
            Vérifiez le message qui s'affiche sur la gauche de la barre latérale qui se trouve toute en bas de la fenêtre d'IntelliJ commence bien avec <samp>"Ant build completed..."</samp>. Une fois vous avez vérifié que la construction (build) a bien eu lieu, cliquez deux fois sur la cible <samp>InterfaceAfficageGrapheDeDependance</samp> sur la partie intitulé <samp>Ant Build</samp> qui se trouve à droite de la fenêtre <samp>d'IntelliJ</samp>. <br>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJAntInterfaceAffichageGrapheDeDependance.png?alt=media&token=5f88ed52-97fa-42e5-9be1-0200ea6f28b3" alt="Vérifiez le message qui s'affiche sur la gauche de la barre latérale qui se trouve tout en bas de la fenêtre d'IntelliJ commence bien avec Ant build completed... Une fois vous avez vérifié que la construction (build) a bien eu lieu, cliquez deux fois sur la cible InterfaceAffichageGrapheDeDependace surla partie intitulé Ant Build qui se trouve à droite de la fenêtre d'IntelliJ"/>
          </li>
        </ol>
      </details>
    </strong>
 </ol> 
</details>

<details>
  <summary> Sur <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Fterminal.png?alt=media&token=df454a13-1480-4c33-a86e-4b22d6f8db99" alt="Command line logo" width="32" height="32" align="top"/> la ligne des commandes
  </summary>
  <ul>
    <li>
      Sur un terminal lancer la commande suivante <br/>
      <code>ant InterfaceAffichageGrapheDeDependance</code> <br/>
      <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FterminalInterfaceGrpahDeDependance.png?alt=media&token=a216b30f-3dfc-4503-ab78-02bcb7a0b794" alt="Sur un terminal lancer la commande ant InterfaceAffichageGrapheDeDependance">
    </li>
    <li>
      En utilisant le script d'exécution selon votre système d'exécution
      <ul> 
        <li>
          <strong>Sous systèmes UNIX</strong> <br/>
          Dans un terminal lancer le script <samp>run.sh</samp> par la commande suivante <br/>
          <code>./run.sh</code>
        </li>
        <li>
          <strong>Sous systèmes Windows</strong><br/>
          Lancer le fichier <strong><samp>run.bat</samp></strong>
        </li>
    </li>
  </ul>
</details>

### L'application complet

<details>
  <summary> Sous <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Feclipse.svg?alt=media&token=c1a40189-1236-407b-9568-52c292e46e3d" alt="Eclipse Logo" width="32" height="32" align="top"/> Eclipse </summary>
  <ul>
    <li>
      <details>
        <summary>
          En exécutant <strong>manuellement le fichier <samp>GenrationToDisplayMain</samp></strong> (<em>Risque de ne pas marcher si vous avez importé le projet en utilisant l'intégration <samp>git</samp></em>)
        </summary>
        <ol>
          <li>
            Faites <strong>un clique droit sur le dossier principal</strong> contenant le projet. Puis dans le menu déroulant cliquez sur <strong><samp>Java Application</samp></strong> sous la section <strong><samp>Run As</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FrunEclipse1.png?alt=media&token=e121056e-c502-4f98-a91b-1eb40e988cfe" alt="Faites un clique droit sur le dossier principal contenant le projet. Puis dans le menu déroulant cliquez sur Java Application sous la section Run As">
          </li>
          <li>
            Sur la fenêtre intitulée <samp>Select Java Application</samp> <strong>sélectionnez <samp>GenrationToDisplayMain - com.puck.utilities.javafx</samp></strong>. Puis cliquez sur le bouton <strong><samp>OK</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FeclipseExecComplet.png?alt=media&token=5f5e9ca4-3ba9-4646-b0fd-a43309f3bc63" alt="Sur la fenêtre intitulée Select Java Application sélectionnez GenrationToDisplayMain - com.puck.utilities.javafx. Puis cliquez sur le bouton OK.">
          </li>
        </ol>
      </details>
    </li>
    <li>
      <details>
        <summary>
          En utilisant le fichier <strong><samp>build.xml</samp></strong>
        </summary>
        <ol>
          <li>
            Faites <strong>un clique droit sur le fichier <samp>build.xml</samp></strong> dans le répertoire principal de projet. Puis dans le menu déroulant cliquez sur <strong><samp>2 Ant Build...</samp></strong> sous la section <strong><samp>Run As</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FbuildXMLEclipse0.png?alt=media&token=f61f27e5-c1d5-48b4-88bc-ea0cfd37bdb2" alt="Faites un clique droit sur le dossier principal contenant le projet. Puis dans le menu déroulant cliquez sur 2 Ant Build... sous la section Run As">
          </li>
          <li>
            Sur la fenêtre intitulée <samp>Edit Configuration</samp> <strong>chochez les cases <samp>build [default]</samp> et <samp>InterfaceAdmin</samp></strong>. Vérifiez bien que l'ordre dans la section <samp>Target execution order:</samp> est <samp>build, InterfaceAdmin</samp>. Puis cliquez sur le bouton <strong><samp>Run</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FbuildXMLEclipse1.png?alt=media&token=03bc934d-3841-4ae3-b8d3-d39f130329d9" alt="Sur la fenêtre intitulée Edit Configuration cochez les cases build [default] et InterfaceAdmin. Vérifiez bien que l'ordre dans la section Target execution order est build, InterfaceAdmin. Puis cliquez sur le bouton Run">
          </li>
        </ol>
      </details>
    </li>
  </ul>

</details>

<details>
  <summary> Sous <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJ_IDEA_Logo.svg?alt=media&token=4f8c266b-4d1c-4fa5-972a-19dbb23ad1be" alt="Eclipse Logo" width="32" height="32" align="top"/> IntelliJ </summary>

  <ul>
    <li>
      <details>
        <summary>
          En exécutant manuelement le fichier <samp>GenrationToDisplayMain</samp>.
        </summary>
        <ol>
          <li>
            Chargez le projet <strong>en sélectionnant le projet</strong> sur la fenêtre de démarrage.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJOpenForAntbuild.png?alt=media&token=bdd1f3e9-50fb-4b60-8563-176237fbebca" alt="Faites un clique droit sur le dossier principal contenant le projet. Puis dans le menu déroulant cliquez sur Java Application sous la section Run As">
          </li>
          <li>
            Trouvez le fichier <strong><samp>GenrationToDisplayMain</samp></strong> qui se trouve dans le dossier <samp>javafx</samp> qui se trouve dans le dossier <samp>utilities</samp> qui se trouve dans le dossier <samp>com.puck</samp> qui se trouve dans le dossier <samp>src</samp> qui se trouve dans le dossier principal du projet. <strong>Faites un clique droit sur ce fichier</strong> et dans le menu déroulant <strong>cliquez sur <samp>Run 'GenrationToDis....main()'</samp></strong>.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJExecComplet.png?alt=media&token=e62be246-1bac-46cb-80fd-12b6d2418f5d" alt="Trouvez le fichier GenrationToDisplayMain qui se trouve dans le dossier javafx qui se trouve dans le dossier utilities qui se trouve dans le dossier com.puck qui se trouve dans le dossier src qui se trouve dans le dossier principal du projet. Faites un clique droit sur ce fichier et dans le menu déroulant cliquez sur Run 'GenrationToDis....main()'">
          </li>
        </ol>
      </details>
    </li>
    <li>
      <details>
        <summary>
          En utilisant <samp>Ant Build</samp>
        </summary>
        <ol>
          <li>
            Chargez le projet <strong>en sélectionnant le projet</strong> sur la fenêtre de démarrage.<br/>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FintelliJOpenForAntbuild.png?alt=media&token=bdd1f3e9-50fb-4b60-8563-176237fbebca" alt="Faites un clique droit sur le dossier principal contenant le projet. Puis dans le menu déroulant cliquez sur Java Application sous la section Run As">
          </li>
          <li>
              Dans la partie intitulé <samp>Ant Build</samp> qui se trouve à droite de la fenêtre <samp>d'IntelliJ</samp>, cliquez deux fois sur la cible <strong><samp>Build</samp></strong>. <em>( Contrairement à Eclipse IntelliJ ne build pas les projets automatiquement, donc il faut le faire manuellement.)</em> <br/>
              <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJAntBuild.png?alt=media&token=c10bfb8c-52ec-4973-9133-bc644ae08854" alt="Dans la partie intitulé Ant Build qui se trouve à droite de la fenêtre d'IntelliJ cliquez deux fois sur la cible Build."/>
          </li>
          <li>
            Vérifiez le message qui s'affiche sur la gauche de la barre latérale qui se trouve toute en bas de la fenêtre d'IntelliJ commence bien avec <samp>"Ant build completed..."</samp>. Une fois vous avez vérifié que la construction (build) a bien eu lieu, cliquez deux fois sur la cible <samp>InterfaceAdmin</samp> sur la partie intitulé <samp>Ant Build</samp> qui se trouve à droite de la fenêtre <samp>d'IntelliJ</samp>. <br>
            <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FIntelliJAntInterfaceAdmin.png?alt=media&token=524c92de-f593-42cf-8767-f02c36da7e58" alt="Vérifiez le message qui s'affiche sur la gauche de la barre latérale qui se trouve tout en bas de la fenêtre d'IntelliJ commence bien avec Ant build completed... Une fois vous avez vérifié que la construction (build) a bien eu lieu, cliquez deux fois sur la cible InterfaceAdmin sur la partie intitulé Ant Build qui se trouve à droite de la fenêtre d'IntelliJ"/>
          </li>
      </details>
  
</details>

<details>
  <summary> Sur <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Fterminal.png?alt=media&token=df454a13-1480-4c33-a86e-4b22d6f8db99" alt="Command line logo" width="32" height="32" align="top"/> la ligne des commandes
  </summary>
  <ol>
    <li>
      Sur un terminal lancer la commande suivante <br/>
      <code>ant InterfaceAdmin</code> <br/>
      <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FterminalInterfaceAdmin.png?alt=media&token=1a46d1f7-dffb-4cde-8fbc-9d49f4794d14" alt="Sur un terminal lancer la commande ant InterfaceAdmin">
    </li>
  </ol>
</details>

## Guide d'utilisation

  Une fois que vous avez réussi à lancer l'interface graphique principal en exécutant le fichier <samp>GenrationToDisplayMain</samp> vous devez avoir la fenêtre suivante : <br/>
  <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FinterfaceAdmin.png?alt=media&token=20b08c2a-1910-410a-a69e-f0fa9d9f6d0f" alt="L'interface de l'application">

  Cette interface vous donne deux options tels que:

  <details>
    <summary><strong>Génerer la graphe de dépendance à afficher</strong> par le code source <samp>Java.</samp></summary>
    <ul>
    <li>
      Pour cela vous devez charger le fichier <samp>jar</samp> du module qui permet de génerer le fichier <samp>xml</samp> contenant la graphe de dépendance. Pour cela vous pouvez utiliser <a href="https://github.com/geoffreycopin/puck2">ceci</a>. Pour le charger cliquez sur le bouton <strong><samp>JAR PUCK2</samp></strong> qui se trouve sur la première ligne de la section <samp>Utiliser la solution basée sur ExtendJ pour générer le fichier XML</samp> et trouvez le fichier <samp>.jar</samp> que vous cherchez à l'aide de l'exploirateur des fichiers.
    </li>
    <li>
      Ainsi vous devez indiquer au moins un fichier <samp>Java</samp> à générer le graph de dépendance. Pour ce faire vous avez deux options : 
      <ul>
        <li>
          Vous pouvez charger un unique fichier <samp>Java</samp> à l'aide de bouton <samp>Class Java à afficher</samp>. Pour le faire cliquez sur le bouton <samp>Class Java à afficher</samp> et sélectionnez le fichier <samp>Java</samp> dont vous utilisez pour l'affichage de graphe de dépendance. 
        </li>
        <li>
        Vous pouvez charger projet complet en <samp>Java</samp> c'est à dire un dossier qui contient plusieurs fichiers <samp>Java</samp> à l'aide de bouton <samp>Projet Java à afficher</samp>. Pour le faire cliquez sur le bouton <samp>Projet Java à afficher</samp> et sélectionnez le dossier de votre projet <samp>Java</samp> dont vous utilisez pour l'affichage de graphe de dépendance. 
        </li>
      </ul>
    </li>
    <li>
    Une fois vous avez indiqué le fichier <samp>.jar</samp> et le(s) fichier(s) <samp>Java</samp> vous cliquez sur le bouton <strong><samp>Run</samp></strong> pour génerer la graphe de dépendance et l'afficher.
    </li>
    </ul>
  </details>

  <details>
    <summary>Chargez un fichier <samp>XML</samp> de graph de dépendance à afficher.</summary>
    Vous pouvez utiliser un fichier <samp>XML</samp> qui représente une graphe de dépendance d'un programme <samp>Java</samp>. Pour ce faire cliquez sur le bouton <strong><samp>Fichier XML</samp></strong> dans la section <samp>Utiliser directement votre propre fichier XML</samp>. Une fois que vous avez cliquez sur ce bouton, sélectionnez le fichier <samp>XML</samp> depuis l'exploirateur des fichiers qui s'ouvre. Après avoir sélectionné le fichier <samp>XML</samp> appuyez sur le bouton <strong><samp>Run</samp></strong>.
  </details>

  Après avoir lancé le programme en utilisant le module ExtendJ et les fichiers Java ou en utilisant simplement un fichier XML vous arrivez sur l'interface graphique de la graphe de dépendance comme ceci:
  <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Fuidg0.png?alt=media&token=baae418f-0268-4380-95d2-b06dc491999e" alt="Interface graphique de graphe de dépendance au démarrage">
  Au démarrage cet interface contient qu'un seul noeud qui s'appelle <samp>root</samp>. Ce noeud est considéré comme le noeud racine de toute la graphe.
  
<ul>
  <li>
    Si vous <strong>cliquez gauche sur la partie textuel d'un noeud fermé</strong> vous pouvez l'<strong>ouvrir</stronh> pour voir ses noeuds enfants.<br/>
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2Fuidg1.png?alt=media&token=996ed984-1924-4f18-8410-ac9c43e88e8e" alt="Tous les noeuds sont ouverts"/>
  </li>
  <li>
    De même pour <strong>un noeud ouvert cliquez gauche sur la partie textuel pour le refermer</strong>. 
  </li>
  <li>
    Toujours sur la partie textuel d'un noeud, vous pouvez cliquez droit pour afficher le menu.
    <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FuidgMenu.png?alt=media&token=3191be29-b7fe-493b-9461-ec38c10221b0" alt="Menu">
    Sur ce menu vous avez 6 options qui sont les suivants:
    <ul>
      <li>
        <samp>Show outgoing edges</samp>: Cette option permet d'afficher les flèches partants du noeud sur lequel on a affiche le menu.
      </li>
      <li>
        <samp>Show hierarchy outgoing edges</samp>: Cette option permet d'afficher les flèches partants du noeud sur lequel on a affiche le menu ainsi que tous ses noeuds enfants.
      </li>
      <li>
        <samp>Show ingoing edges</samp>: Cette option permet d'afficher les flèches entrants du noeud sur lequel on a affiche le menu.
      </li>
      <li>
        <samp>Show hierarchy ingoing edges</samp>: Cette option permet d'afficher les flèches entrants du noeud sur lequel on a affiche le menu ainsi que tous ses noeuds enfants.<br/>
        <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FuidgAll.png?alt=media&token=148688fa-ea72-495e-bed5-9f22bc63d222" alt="Exemple avec les flèches">
      </li>
      <li>
        <samp>Hide edges</samp>: Cette option permet de cacher les flèches concernant le noeud sur lequel on a affiché le menu.
      </li>
      <li>
        <samp>Hide node</samp>: Cette option permet de cacher un noeud en entière. (<em>Ceci n'est pas appliquable sur le noeud <samp>root</samp></em>)<br/>
        <img src="https://firebasestorage.googleapis.com/v0/b/kaan-yagci-website.appspot.com/o/PSTL%20Assets%2FhideNode.png?alt=media&token=f6946bd6-a6a5-49d7-946b-2c4768973741" alt="Quand on cache un noeud">
      </li>
    </ul>
  
  </li>
</ul>