<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#implementation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

***Easy Chip Group*** is an android dependency that facilitates the implementation of chip groups on your android application.


<!-- GETTING STARTED -->
## Getting Started

To implement the ***Easy Chip Group*** you have to follow this simple steps .

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* grandle
  ```sh
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  * dependency
  ```sh
   implementation 'com.github.champiermz:easychipgroup:0.0.1'
  ```

### Implemetation

1. ActivityExample.xml 
   ```sh
         <com.google.android.material.chip.ChipGroup
            android:id="@+id/chipGroup"
            android:layout_width="wrap_content"
            android:layout_height="match_parent">
            
        </com.google.android.material.chip.ChipGroup>
   ```

2. ActivityExample.kt
   ```sh
   import mz.co.champier.easychipgroup.EasyChipGroup
   ```

2.1 On  onCreateView
```sh
      //EXAMPLE
       val list = listOf(
                Gender('M', "Masculino"),
                Gender('F', "Feminino")
        )

        chipGroup.submitList(list) { chip, element ->
            chip.text = element.value
        }
   ```

2.2 Setting Actions
 ```sh
        chipGroup.setOnItemClickListener { element ->
            Toast.makeText(requireContext(), element.key + "", Toast.LENGTH_SHORT).show()
        }
   ```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

