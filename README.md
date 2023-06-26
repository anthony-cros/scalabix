# Scalabix

Resurrecting old code from my time at [The Children's Hospital of Philadelphia (CHOP)](https://www.chop.edu/), between 2016 and 2019, and before I moved back to Canada.

Initially the project was called `Ciphia` and was a web portal to access genomic variant "trio" data (proband/father/mother). I'm renaming the top project as `Scalabix` for (Scala Bioinformatics), and `Ciphia` will now only refer specifically to the ETL/webapp part of the code, since a lot of it can be generalized.

The code needs a fair amount of TLC and migration to newer features of the languages/libraries used.

So far the modules are:
- `scalabix-core`: minimal, mostly a placeholder
- `scalabix-genomics`: ready
- `scalabix-variants`: in progress - mostly to exploit [VCF files](https://en.wikipedia.org/wiki/Variant_Call_Format)
- `scalabix-ciphia-etl`: in progress, will leverage [Gallia](https://github.com/galliaproject/gallia-core) for data transformations; will exploit Gallia's existing sub-projects:
  - [Gallia dbNSFP](https://github.com/galliaproject/gallia-dbNSFP)
  - [Gallia Clinvar](https://github.com/galliaproject/gallia-clinvar)
  - [Gallia SnpEff](https://github.com/galliaproject/gallia-snpeff)
  - [Gallia Genemania](https://github.com/galliaproject/gallia-genemania)
- `scalabix-ciphia-web`: not started, original was written in _TypeScript_ but I'd like to create _Scala.js_ version instead

